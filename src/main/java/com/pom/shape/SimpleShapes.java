package com.pom.shape;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class SimpleShapes implements GLEventListener{
	
	public static final int LINE_STRIP = 0;
	public static final int LINE_LOOP = 1;
	public static final int TRIANGLES = 2;
	public static final int TRIANGLE_STRIP = 3;
	public static final int QUADS = 4;
	public static final int POLYGON =5;
	public static final int TRIANGLE_STRIP_QUAD=6;
	public static final int TRIANGLE_STRIP_DOUBLE_TRIANGLE=7;
	private int shapeID;
	public SimpleShapes(int shapeID) {
		super();
		this.shapeID=shapeID;
		// TODO Auto-generated constructor stub
	}

	//	private GL2 gl;
	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		System.out.println("display is called");
		
		draw(drawable, shapeID);

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	private void draw(GLAutoDrawable drawable, int shapeID)
	{
		DrawShapes.setGLAutoDrawable(drawable);
		switch(shapeID)
		{
			case LINE_STRIP:
				DrawShapes.drawLineStrip();
				break;
			case LINE_LOOP:
				DrawShapes.drawLineLoop();
			case TRIANGLES:
				DrawShapes.drawTriangles();
				break;
			case TRIANGLE_STRIP:
				DrawShapes.drawTriangleStrip();
				break;
			case QUADS:
				DrawShapes.drawQuads();
				break;
			case TRIANGLE_STRIP_QUAD:   /*customized quads*/
				DrawShapes.drawTrianglesStripQuads();
				break;
			case TRIANGLE_STRIP_DOUBLE_TRIANGLE:
				DrawShapes.drawDoubleTriangle();
				break;
			
		}
	}
}
