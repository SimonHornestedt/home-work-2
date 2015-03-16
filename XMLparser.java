import java.util.*;
import java.io.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLparser{
	
	static final String TYPE = "type";
	static final String ITEM = "item";
	static final String ARTIST = "artist";
	static final String TITLE = "title";
	static final String YEAR = "year";
	static final String GRADE = "grade";
	static final String KEY = "ID";
	
	//stax writer

        public void writeXML(String output, List<Item> list ) {

		try{
			output =  output + ".xml";
			// create an XMLOutputFactory
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			// create XMLEventWriter
			XMLEventWriter eventWriter = outputFactory
				.createXMLEventWriter(new FileOutputStream(output));

			// create an EventFactory
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			XMLEvent end = eventFactory.createDTD("\n");
			XMLEvent tab = eventFactory.createDTD("\t");
			// create and write Start Tag
			StartDocument startDocument = eventFactory.createStartDocument();
			eventWriter.add(startDocument);

			// create config open tag
			StartElement libStartElement = eventFactory.createStartElement("",
				"", "library");
				  eventWriter.add(end);
			eventWriter.add(libStartElement);
			eventWriter.add(end);
			StartElement itemStartElement = eventFactory.createStartElement("",
				"", "item");
	  
			// Write the different nodes
			for(Item it : list){
				eventWriter.add(tab);
				eventWriter.add(itemStartElement);
				eventWriter.add(end);
				createNode(eventWriter, "ID", Integer.toString( it.getID()) );
				createNode(eventWriter, "title", it.getName() );
                                createNode(eventWriter, "type", it.getType() );
                                createNode(eventWriter, "creator", it.getCreatorName() );
				createNode(eventWriter, "grade", Integer.toString(it.getScore()));
				eventWriter.add(tab);
				eventWriter.add(eventFactory.createEndElement("", "", "item"));
				eventWriter.add(end);
			}
      
			eventWriter.add(eventFactory.createEndElement("", "", "library"));
			eventWriter.add(end);
			eventWriter.add(eventFactory.createEndDocument());
			eventWriter.close();
		} catch (XMLStreamException | IOException e) {
     		e.printStackTrace();
		}
    }

    private static void createNode(XMLEventWriter eventWriter, String name,
        String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);

		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

    }

	//Stax reader
	@SuppressWarnings({ "unchecked", "null" })
	public static ArrayList<Item> readXML(String xmlFile) {
		ArrayList<Item> items = new ArrayList<>();
		try {
	    		// First, create a new XMLInputFactory
	      	  	XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	      	  	// Setup a new eventReader
	      	 	InputStream in = new FileInputStream(xmlFile);
	      	   	XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	      	  	// read the XML document
	      	  	Item item = null;
                        
	      	  	while (eventReader.hasNext()) {
	      		XMLEvent event = eventReader.nextEvent();

                        
	        	if (event.isStartElement()) {
	          		StartElement startElement = event.asStartElement();
	          	  	// If we have an item element, we create a new item
					
					Iterator<Attribute> attributes = startElement.getAttributes();
	            	while (attributes.hasNext()) {
	              		Attribute attribute = attributes.next();
	              		if (attribute.getName().toString().equals(KEY)) {
	                		item.setID( Integer.valueOf(attribute.getValue()) );
	              		}
                                }
	          	  	if (event.isStartElement()) {
	            			if ( event.asStartElement().getName().getLocalPart().equals(ARTIST) ) {
	              			event = eventReader.nextEvent();
	              			item.setCreatorName(event.asCharacters().getData());
	              		  	continue;
	            			}
	          		}
	          	  	if ( event.asStartElement().getName().getLocalPart().equals(TITLE) ) {
	            			event = eventReader.nextEvent();
	            			item.setName(event.asCharacters().getData());
	            			continue;
	        		}
	          	  	if ( event.asStartElement().getName().getLocalPart().equals(GRADE)) {
	            			event = eventReader.nextEvent();
	            			item.setScore(Integer.parseInt(event.asCharacters().getData()));
	            			continue;
	        		}
	        	}
	        	// If we reach the end of an item element, we add it to the list
	        	if (event.isEndElement()) {
	          		EndElement endElement = event.asEndElement();
	          	  	if (endElement.getName().getLocalPart().equals(ITEM)) {
	            			items.add(item);
	          		}
	        	}

	      	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	  	} catch (XMLStreamException e) {
	    		e.printStackTrace();
	    	}
	    	return items;
	}
} 