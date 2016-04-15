/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatc;

import Objets.Statut;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author CHEIKH TOURAD et RUKUNDO Fiston
 */
public class StatutComboBox extends JPanel{
    ImageIcon[] images;
    String[] petStrings = {"Disponible", "Absent", "Occupé", "Hors ligne"};
    JComboBox petList;

    public StatutComboBox() {
        super(new BorderLayout());

        //Load the pet images and create an array of indexes.
        images = new ImageIcon[petStrings.length];
        Integer[] intArray = new Integer[petStrings.length];
        for (int i = 0; i < petStrings.length; i++) {
            intArray[i] = new Integer(i);
            images[i] = new ImageIcon("images/" + petStrings[i] + ".gif");
            if (images[i] != null) {
                images[i].setDescription(petStrings[i]);
            }
        }

        //Create the combo box.
        petList = new JComboBox(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(200, 20));
        petList.setRenderer(renderer);
        petList.setMaximumRowCount(4);

        //Lay out the demo.
        add(petList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }
    
    public Statut getStatut(){
        if(petList.getSelectedIndex()==0)
            return Statut.disponible;
        if(petList.getSelectedIndex()==1)
            return Statut.absent;
        
        if(petList.getSelectedIndex()==2)
            return Statut.occupe;
        
        if(petList.getSelectedIndex()==3)
            return Statut.horsligne;
        
        return  null;
    }


    class ComboBoxRenderer extends JLabel
                           implements ListCellRenderer {
        private Font uhOhFont;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */
        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String pet = petStrings[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(pet);
                setFont(list.getFont());
            } else {
                setUhOhText(pet + " (no image available)",
                            list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }
}
