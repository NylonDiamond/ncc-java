package sf.codingcomp.gui;

import sf.codingcomp.SearchServiceImplementation;
import sf.codingcomp.model.Entertainment;
import sf.codingcomp.model.Game;
import sf.codingcomp.model.Movie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by jskelton8 on 3/23/2017.
 */
public class firstGuiForm {
    private JButton submitButton;
    private JPanel firstPanel;
    public JTextField textField1;
    private JButton searchMoviesButton;
    private JButton searchGamesButton;

    public firstGuiForm() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String title =  textField1.getText();
                SearchServiceImplementation service = new SearchServiceImplementation();
                List<Entertainment> items = service.searchGameAndMovies(title);
    System.out.print(items);
                String concat = "";
                for(Entertainment item : items){
                    concat += item.getTitle() + '\n';
                }
                JOptionPane.showMessageDialog(null, concat);

            }
        });
        searchMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String title =  textField1.getText();
                SearchServiceImplementation service = new SearchServiceImplementation();
                List<Movie> items = service.searchMovie(title);
                System.out.print(items);
                String concat = "";
                for(Entertainment item : items){
                    concat += item.getTitle() + '\n';
                }
                JOptionPane.showMessageDialog(null, concat);
            }
        });
        searchGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String title =  textField1.getText();
                SearchServiceImplementation service = new SearchServiceImplementation();
                List<Game> items = service.searchGame(title);
                System.out.print(items);
                String concat = "";
                for(Entertainment item : items){
                    concat += item.getTitle() + '\n';
                }
                JOptionPane.showMessageDialog(null, concat);
            }
        });
    }

    public static void main(String[] args){
        JFrame jFrame = new JFrame("StartUpClass");
        jFrame.setContentPane(new firstGuiForm().firstPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
