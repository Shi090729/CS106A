/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {
	private ArrayList<NameSurferEntry> entries = new ArrayList<NameSurferEntry>();

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
	}

	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
		public void clear() {
			entries.clear();
	}

	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
		public void addEntry(NameSurferEntry entry) {
			if (entry != null) entries.add(entry);
	}



	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
		public void update() {
			removeAll(); double w=getWidth(), h=getHeight();
			for (int i=0;i<=NDECADES;i++){double x=i*w/NDECADES;add(new GLine(x,0,x,h));if(i<NDECADES)add(new GLabel(String.valueOf(START_DECADE+i*10),x+2,h-2));}
			add(new GLine(0,GRAPH_MARGIN_SIZE,w,GRAPH_MARGIN_SIZE)); add(new GLine(0,h-GRAPH_MARGIN_SIZE,w,h-GRAPH_MARGIN_SIZE));
			Color[] colors={Color.RED,Color.BLUE,Color.BLACK,Color.MAGENTA,Color.ORANGE,Color.GREEN};
			for(int k=0;k<entries.size();k++){NameSurferEntry e=entries.get(k);double px=0,py=0;for(int i=0;i<NDECADES;i++){int rank=e.getRank(i);double x=i*w/(NDECADES-1),y=rank==0?h-GRAPH_MARGIN_SIZE:GRAPH_MARGIN_SIZE+(h-2*GRAPH_MARGIN_SIZE)*rank/(double)MAX_RANK;if(i>0){GLine line=new GLine(px,py,x,y);line.setColor(colors[k%colors.length]);add(line);}GLabel lab=new GLabel(e.getName()+" "+rank,x+2,y-2);lab.setColor(colors[k%colors.length]);add(lab);px=x;py=y;}}
	}




	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
