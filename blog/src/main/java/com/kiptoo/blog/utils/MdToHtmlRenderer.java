package com.kiptoo.blog.utils;

import java.util.List;

import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.parser.Parser;

public class MdToHtmlRenderer {
	
	public static String renderHtml(List<String> markdownLines) {
		Parser parser = Parser.builder().build();
		HtmlRenderer renderer = HtmlRenderer.builder().build();

		StringBuilder renderedSB = new StringBuilder();
		for (String markdownLine : markdownLines) {
			Node document = parser.parse(markdownLine);
			renderedSB.append(renderer.render(document));
		}
		return new String(renderedSB);
	}
}