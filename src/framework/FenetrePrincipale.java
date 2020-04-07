package framework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


public class FenetrePrincipale extends JFrame{
	
	private final int ZOOMLEVEL = 10;
	private final int WIDTH = 800;
	private final int HEIGHT = 800;
	
	private JFrame j;
	private JMenu jmenu;
	private JMenuBar jbar;
	private JMenuItem open, save, exit;
	private JPanel jpanel;
	private JFileChooser fileChooser;
	private File selectedFile;
	private JScrollPane scroll;
	
	int newWidth;
	int newHeight;
	
	JLabel image = null;
	BufferedImage img;
	ImageIcon imIcon;
	
	private JFileChooser saveFile;
	BufferedImage saveImg;
	int[][] pixels;
	
	/*
	 * Inspire de https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/16345968#16345968
	 * et de https://stackoverflow.com/questions/17219129/how-to-use-jfilechooser-to-display-image-in-a-jpanel
	 */
	public FenetrePrincipale() {
		
		j = new JFrame();
		
		// creating scrollPane
		scroll = new JScrollPane();
		
		
		
		// creating image panel
		jpanel = new JPanel();
		jpanel.setLayout(new BorderLayout());
		image = new JLabel(" ");
		jpanel.add(image, BorderLayout.CENTER);
		
		j.add(jpanel);
		
		// creating menu
		jbar = new JMenuBar();
		jmenu = new JMenu("Fichier");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		exit = new JMenuItem("Quitter");
		
		open.addActionListener((ActionEvent e) -> {
			
			fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle("Open Image");
			fileChooser.setAcceptAllFileFilterUsed(false);
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".png, .jpg, .jpeg", "png", "jpg", "jpeg");
			fileChooser.addChoosableFileFilter(filter);
			
			int returnValue = fileChooser.showOpenDialog(null);
			
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();
				try {
					img = ImageIO.read(selectedFile);
					imIcon = new ImageIcon(img);
					image.setIcon(imIcon);
					newWidth = image.getWidth();
					newHeight = image.getHeight();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}			
		});
				
		/*
		save.addActionListener((ActionEvent e) -> {
			
			saveFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			saveFile.setDialogTitle("Save Image");
			
			int returnValue = saveFile.showSaveDialog(null);
			
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = saveFile.getSelectedFile();
					
				ImageIO.write(saveImg, "png", selectedFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		*/
		exit.addActionListener((ActionEvent e) -> {
			
			System.exit(0);
		});
		
		jmenu.add(open);
		jmenu.add(save);
		jmenu.add(exit);
		
		jbar.add(jmenu);
		
		
		// creating frame
		j.add(jbar, BorderLayout.NORTH);
		
		
		
		j.setTitle("Laboratoire 3");
		j.setSize(new Dimension(HEIGHT,WIDTH));
		j.setVisible(true);
		j.setLocationRelativeTo(null);
		j.setResizable(false);
		
		
		jpanel.addMouseWheelListener(new MouseWheelListener(){
		
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

					int point = e.getWheelRotation();
					if (point < 0) {
						zoomIn();
						e.getUnitsToScroll();
					} else {
						zoomOut();
						e.getUnitsToScroll();
					}
			}				
		});
		
	}
	
	public Image resize(int width, int height, Image img) {
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, width, height, null);
		g2.dispose();
		return bi;
	}
	
	public void zoomIn() {
		if (selectedFile != null) {
			try {
				newWidth = newWidth + 100;
				newHeight = newWidth + 100;
				Image temp = ImageIO.read(selectedFile);
				ImageIcon ic = new ImageIcon(resize(newWidth, newHeight, temp));
				image.setIcon(ic);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void zoomOut() {
		if (selectedFile != null) {
			try {
				newWidth = newWidth - 100;
				newHeight = newHeight - 100;
				Image temp = ImageIO.read(selectedFile);
				ImageIcon ic = new ImageIcon(resize(newWidth, newHeight, temp));
				image.setIcon(ic);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
