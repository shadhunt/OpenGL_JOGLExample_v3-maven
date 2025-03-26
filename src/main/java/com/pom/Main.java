package com.pom;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Main implements GLEventListener{


	public static void main(String[] args) {
		System.out.println("JOGL Example V3.0");
        SwingUtilities.invokeLater(() -> {
//            GLProfile profile = GLProfile.getDefault();
        	GLProfile profile = GLProfile.get(GLProfile.GL2);
            GLCapabilities capabilities = new GLCapabilities(profile);
            GLCanvas canvas = new GLCanvas(capabilities);
            canvas.addGLEventListener(new Main());

            JFrame frame = new JFrame("JOGL with Maven");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(canvas);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    	System.out.println("in init");
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    	System.out.println("in display");
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f); gl.glVertex2f(-0.5f, -0.5f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); gl.glVertex2f( 0.5f, -0.5f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); gl.glVertex2f( 0.0f,  0.5f);
        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    	System.out.println("in dispose");
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    	System.out.println("in reshape");
    	GL2 gl = drawable.getGL().getGL2();
    	gl.glViewport(0, 0, width, height);
    }
}
