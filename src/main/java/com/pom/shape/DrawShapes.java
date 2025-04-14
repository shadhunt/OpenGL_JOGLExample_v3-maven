package com.pom.shape;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class DrawShapes {

	private static GL2 gl;
	private static GLAutoDrawable drawable;
	public static void setGLAutoDrawable(GLAutoDrawable drawable)
	{
		DrawShapes.drawable=drawable;
		DrawShapes.gl = drawable.getGL().getGL2();
	}
	public static void drawLineStrip()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_LINE_STRIP);
		
		gl.glVertex3f(-0.5f, -0.75f,0);
		gl.glVertex3f(0.7f, .5f, 0);
		gl.glVertex3f(0.7f,-0.7f,0);
		gl.glVertex3f(0f, 0.5f, 0);
		gl.glEnd();
		gl.glFlush();
	}
	
	public static void drawLineLoop()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_LINE_LOOP);
		
		gl.glVertex3f(-0.5f,-0.75f,0);
		gl.glVertex3f(0.7f,.5f,0);
		gl.glVertex3f(0f,0.5f,0);
		gl.glEnd();
	}
	
	public static void drawTriangles()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLES);
		
		gl.glVertex3f(0.5f, 0.7f, 0.0f);
		gl.glVertex3f(-0.2f,-0.50f, 0.0f);
		gl.glVertex3f(0.5f, -0.5f, 0);
		
		gl.glEnd();
	}
	
	public static void drawTriangleStrip()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		
		setGlColor3f(0.7f, 0.4f, 0);
		gl.glVertex3f(0f, 0.5f, 0);
		gl.glVertex3f(-.5f,-.75f,0);
		setGlColor3f(0, 0.4f, -0.3f);
		gl.glVertex3f(0.28f, 0.06f, 0);
//		setGlColor3f(0, 0.4f, -0.3f); // TODO: ?? what if I don't want color graduate change
		gl.glVertex3f(0.7f, 0.5f, 0);
		gl.glVertex3f(0.7f, -0.7f, 0);
		
		gl.glEnd();
	}
	
	public static void drawQuads()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		gl.glVertex3f(0f,0.75f,0);
		gl.glVertex3f(-0.75f,0,0);
		gl.glVertex3f(0,-0.75f,0);
		gl.glVertex3f(0.75f, 0, 0);
//		gl.glVertex3f(0f,0.75f,0);  // need this if the Primitive Type into Triangle Strip
		gl.glEnd();
		
	}
	
	public static void drawTrianglesStripQuads()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);

		VertexParam vp1 = new VertexParam(-0.25f, 0.25f, 0);
		VertexParam vp2 = new VertexParam(0.25f, 0.25f, 0);
		VertexParam vp3 = new VertexParam(0.25f,-0.25f, 0);
		VertexParam vp4 = new VertexParam(-0.25f,-0.25f, 0);
		VertexParam vp5 = new VertexParam(-0.25f, 0.25f, 0);

		drawVertexParamTriangle(vp1, vp2, vp3, vp4, vp5);
		
		gl.glEnd();
	}
	
	
	public static void drawDoubleTriangle()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		VertexParam vp1 = new VertexParam(-0.3f, 0.4f, 0);
		VertexParam vp2 = new VertexParam(-0.05f, -0.4f, 0);
		VertexParam vp3 = new VertexParam(0.45f, 0.6f, 0);
		VertexParam vp4 = new VertexParam(-0.7f, 0.3f, 0);
		VertexParam vp5 = new VertexParam(0.5f,0.9f,0);
		gl.glColor3f(0, 0.7f, 0.5f);
		drawToVertex(vp1);
		drawToVertex(vp2);
		drawToVertex(vp3);
		gl.glColor3f(0.2f, 0.7f, 0);
		drawToVertex(vp4);
		drawToVertex(vp5);
		gl.glEnd();
	}
	
	
	public static void drawTripleTriangle()
	{
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		VertexParam vp1 = new VertexParam(-0.3f, 0.4f, 0);
		VertexParam vp2 = new VertexParam(-0.05f, -0.4f, 0);
		VertexParam vp3 = new VertexParam(0.45f, 0.6f, 0);
		VertexParam vp4 = new VertexParam(0.7f, 0.3f, 0);
		VertexParam vp5 = new VertexParam(0.9f,0.8f,0);
		gl.glColor3f(0, 0.7f, 0.5f);
		drawToVertex(vp1);
		drawToVertex(vp2);
		drawToVertex(vp3);
		gl.glColor3f(0.2f, 0.7f, 0);
		drawToVertex(vp4);
		drawToVertex(vp5);
		gl.glEnd();
	}
	
	/**
	 * call gl.glEnd() after finally finished using this method
	 * @param vertexParam
	 */
	private static void drawVertexParamTriangle(VertexParam v1, VertexParam v2, VertexParam v3, VertexParam v4, VertexParam v5 )
	{
		setGlColor3f(0.2f, 0, 0.6f);
		gl.glVertex3f(v1.getX(), v1.getY(), 0);
		gl.glVertex3f(v2.getX(), v2.getY(), 0);
		setGlColor3f(-0.4f, 0, 0.2f);
		gl.glVertex3f(v3.getX(), v3.getY(), 0);
		gl.glVertex3f(v4.getX(), v4.getY(), 0);
		gl.glVertex3f(v5.getX(), v5.getY(), 0);
	}
	private static void drawToVertex(VertexParam vp)
	{
		gl.glVertex3f(vp.getX(), vp.getY(), vp.getZ());
	}
	private static void setGlColor3f(float r, float g, float b)
	{
		gl.glColor3f(r, g, b);
	}
	
}
