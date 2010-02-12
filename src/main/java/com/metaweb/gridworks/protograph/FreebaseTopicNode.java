package com.metaweb.gridworks.protograph;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

public class FreebaseTopicNode implements Node, NodeWithLinks {
	private static final long serialVersionUID = 8418548867745587387L;

	final public FreebaseTopic topic;
	final public List<Link> links = new LinkedList<Link>();
	
	public FreebaseTopicNode(FreebaseTopic topic) {
		this.topic = topic;
	}

	public void write(JSONWriter writer, Properties options)
			throws JSONException {
		
		writer.object();
		writer.key("nodeType"); writer.value("topic");
		writer.key("topic"); topic.write(writer, options);
		
		writer.key("links"); writer.array();
		for (Link link : links) {
			link.write(writer, options);
		}
		writer.endArray();

		writer.endObject();
	}

	public void addLink(Link link) {
		links.add(link);
	}
}