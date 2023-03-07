package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainSceneController {

    File fileFrom;
    File fileTo;
    double readSize = 0;
    double writeCount = 0;
    boolean moveRec = false;
    @FXML
    private Button btnCopy;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnFrom;
    @FXML
    private Button btnMove;
    @FXML
    private Button btnTo;
    @FXML
    private ProgressBar prg;
    @FXML
    private TextField txtFrom;
    @FXML
    private TextField txtTo;

    public void initialize() {
    }

    @FXML
    void btnFromOnAction(ActionEvent event) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        fileFrom = chooser.getSelectedFile();

//        DirectoryChooser dirChooser = new DirectoryChooser();
//        fileFrom = dirChooser.showDialog(btnFrom.getScene().getWindow());

//        FileChooser fileChooser = new FileChooser();
//        fileFrom = fileChooser.showOpenDialog(btnFrom.getScene().getWindow());

        if (fileFrom == null) {
            txtFrom.setText("");
        } else {
            txtFrom.setText(fileFrom.getAbsolutePath());
        }
    }

    @FXML
    void btnToOnAction(ActionEvent event) {
        DirectoryChooser dirChooser = new DirectoryChooser();
        fileTo = dirChooser.showDialog(btnTo.getScene().getWindow());

        if (txtTo == null) {
            txtTo.setText("");
        } else {
            txtTo.setText(fileTo.getAbsolutePath());
        }
    }

    @FXML
    void btnCopyOnAction(ActionEvent event) {
        moveRec = false;
        writeCount = 0;
        if (fileFrom == null || fileTo == null) {
            return;
        } else if (fileFrom.isFile()) {
            fileTo = new File(fileTo, fileFrom.getName());
            readSize = fileFrom.length();
            copySingleFile(fileFrom, fileTo);
            System.out.println("Write completed");
        } else if (fileFrom.isDirectory()) {
            getSize(fileFrom);
            File newFile = new File(fileTo, fileFrom.getName());
            newFile.mkdir();
            copyRecursion(fileFrom, newFile);
            System.out.println("Write completed");
        }


    }

    @FXML
    void btnMoveOnAction(ActionEvent event) {
        if (fileFrom == null || fileTo == null) {
            return;
        }
//        else if (fileFrom.isFile()) {
//            moveRec = false;
//            fileTo = new File(fileTo, fileFrom.getName());
//            readSize = fileFrom.length();
//            moveSingleFile(fileFrom, fileTo);
//            System.out.println("Move completed");
//        } else if (fileFrom.isDirectory()) {
//            moveRec = true;
//            getSize(fileFrom);
//            File newFile = new File(fileTo, fileFrom.getName());
//            newFile.mkdir();
//            moveRecursion(fileFrom, newFile);
////            fileFrom.delete();
//            System.out.println("Move completed");
//        }
        fileFrom.renameTo(new File(fileTo, fileFrom.getName()));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (fileFrom == null) {
            return;
        } else if (fileFrom.isFile()) {
            fileFrom.delete();
            System.out.println("Delete completed");
        } else if (fileFrom.isDirectory()) {
            deleteRecursion(fileFrom);
            fileFrom.delete();
            System.out.println("Delete completed");
        }
    }

    public void copySingleFile(File start, File destination) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                try {
                    FileInputStream fis = new FileInputStream(start);
                    FileOutputStream fos = new FileOutputStream(destination, true);

                    while (true) {
                        byte[] bytes = new byte[1024];
                        int read = fis.read(bytes);


                        if (read == -1) {
                            break;
                        } else {
                            fos.write(bytes, 0, read);
                            writeCount += read;
                            double percentage = writeCount / readSize;
//                            System.out.println(writeCount);
//                            System.out.println(readSize);
//                            System.out.println("--------------");
                            updateProgress(percentage, 1.0);
//                            System.out.println(writeCount/readSize);
                        }
                    }

                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        task.setOnSucceeded(workerStateEvent -> {
//            prg.progressProperty().unbind();
//            prg.setProgress(writeCount/readSize);
            System.out.println(writeCount*100/readSize);
            System.out.println("--------------");
        });

        new Thread(task).start();
        prg.progressProperty().unbind();
        prg.progressProperty().bind(task.progressProperty());
    }

    public void copyRecursion(File copyFrom, File copyTo) {
        File[] filesList = copyFrom.listFiles();
//        if (filesList.length == 0) {
//            return;
//        }
        for (File file : filesList) {
            if (file.isFile()) {
                copySingleFile(file, new File(copyTo, file.getName()));
            } else if (file.isDirectory()) {
                File newFile = new File(copyTo, file.getName());
                newFile.mkdir();
                copyRecursion(file, newFile);
            }
        }
    }

    public void getSize(File file) {
        File[] filesArray = file.listFiles();
        for (File selectedFile : filesArray) {
            if (selectedFile.isFile()) {
                readSize += selectedFile.length();
            } else if (selectedFile.isDirectory()) {
                getSize(selectedFile);
            }
        }
    }

    public void deleteRecursion(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                deleteRecursion(file);
                file.delete();
            }
        }
    }

    public void moveSingleFile(File start, File destination) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                try {
                    FileInputStream fis = new FileInputStream(start);
                    FileOutputStream fos = new FileOutputStream(destination, true);

                    while (true) {
                        byte[] bytes = new byte[1024];
                        int read = fis.read(bytes);


                        if (read == -1) {
                            break;
                        } else {
                            fos.write(bytes, 0, read);
                            writeCount += read;
                            updateProgress(writeCount / readSize, 2);
//                            System.out.println(writeCount/readSize);
                        }
                    }

                    fis.close();
                    fos.close();

                    start.delete();
                    if (moveRec) {
                        start.getParentFile().delete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        new Thread(task).start();
//        prg.progressProperty().unbind();
        prg.progressProperty().bind(task.progressProperty());
    }

    public void moveRecursion(File copyFrom, File copyTo) {
        File[] filesList = copyFrom.listFiles();
//        if (filesList.length == 0) {
//            return;
//        }
        for (File file : filesList) {
            if (file.isFile()) {
                moveSingleFile(file, new File(copyTo, file.getName()));
            } else if (file.isDirectory()) {
                File newFile = new File(copyTo, file.getName());
                newFile.mkdir();
                moveRecursion(file, newFile);
                file.delete();
            }
        }
    }

    public File[] sort(File[] input) {
        File[] newFileArray = new File[input.length];
        int i = 0;

        for (File file : input) {
            if (file.isDirectory()) {
                newFileArray[i] = file;
                i++;
            }
        }

        for (File file : input) {
            if (file.isFile()) {
                newFileArray[i] = file;
                i++;
            }
        }
        return newFileArray;
    }

}
