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
import com.pom.shape.Triangle;

public class Main{


	public static void main(String[] args) {
		System.out.println("JOGL Example V3.0");
        SwingUtilities.invokeLater(() -> {
//            GLProfile profile = GLProfile.getDefault();
        	GLProfile profile = GLProfile.get(GLProfile.GL2);
            GLCapabilities capabilities = new GLCapabilities(profile);
            GLCanvas canvas = new GLCanvas(capabilities);
            canvas.addGLEventListener(new Triangle());

            JFrame frame = new JFrame("JOGL with Maven");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(canvas);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
