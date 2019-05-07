package minkowitz.net;

import io.reactivex.disposables.Disposable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoListFrame extends JFrame {

    private final JLabel imageLabel;
    private final JButton previousButton = new JButton("Previous");
    private final JButton nextButton = new JButton("Next");
    private final JLabel currentNumberLabel = new JLabel("");
    private final Disposable disposable;
    private final JList photoSideBar;

    private PhotoList photoList;
    private int counter = 0;

    public PhotoListFrame() {
        setSize(800, 600);
        setTitle("PhotoList");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        imageLabel = new JLabel();
        root.add(imageLabel, BorderLayout.CENTER);

        JPanel bottomPanel = createBottomPanel();
        root.add(bottomPanel, BorderLayout.SOUTH);

        photoSideBar = new JList();
        root.add(photoSideBar, BorderLayout.EAST);

        setContentPane(root);

        JsonPlaceholderClient client = new JsonPlaceholderClient();
        disposable = client.getPhotoList()
                .subscribe(photos -> {
                    photoList = photos;
                    setPhoto(photos.get(counter));
                    setSideBar(photos);
                    setListListener();
                });

        onWindowClose();
    }


    public void setPhoto(Photo photo) {
        try {
            imageLabel.setIcon(new ImageIcon(new URL(photo.getUrl())));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setSideBar(PhotoList photos)
    {
        DefaultListModel listModel = new DefaultListModel();
        for (Photo photo : photoList) {
            listModel.addElement(photo.getTitle());
        }
        photoSideBar.setModel(listModel);
    }

    public void setListListener()
    {
        photoSideBar.addListSelectionListener(listSelectionListener -> {
            int photoIndex = photoSideBar.getSelectedIndex();
            updatePhotoNumber(photoIndex);
            setPhoto(photoList.get(photoIndex));
        });
    }
    public void updatePhotoNumber() {
        currentNumberLabel.setText(String.valueOf(counter + 1));
    }

    public void updatePhotoNumber(int index) {
        currentNumberLabel.setText(String.valueOf(index + 1));
    }

    public void onWindowClose()
    {
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                // always dispose your disposable when closing the window.
                disposable.dispose();
            }
        });
    }

    public JPanel createBottomPanel()
    {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        setUpPreviousButton();
        setUpNextButton();
        currentNumberLabel.setText("" + Integer.toString(counter + 1));
        bottomPanel.add(previousButton);
        bottomPanel.add(currentNumberLabel);
        bottomPanel.add(nextButton);
        return bottomPanel;
    }

    public void setUpPreviousButton()
    {
        previousButton.addActionListener(actionEvent -> {
            if(counter > 0) {
                counter--;
            }
            setPhoto(photoList.get(counter));
            updatePhotoNumber();
        });
    }

    public void setUpNextButton()
    {
        nextButton.addActionListener(actionEvent -> {
            if(counter < photoList.size()) {
                counter++;
            }
            setPhoto(photoList.get(counter));
            updatePhotoNumber();
        });
    }

    public static void main(String[] args) {
        new PhotoListFrame().setVisible(true);
    }

}