package sample;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Splash extends Preloader{

    private Label lblProgress;
    private ProgressBar barra;
    private Stage stage;
    private Scene scene;

    public Splash() {
        super();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type=info.getType();

        switch (type){
            case BEFORE_START:{
                stage.hide();

                break;
            }
        }//Llave swich
    }



    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if(info instanceof ProgressNotification){
            lblProgress.setText(((ProgressNotification)info).getProgress()+"%");
            barra.setProgress(((ProgressNotification)info).getProgress()/100);
        }//Llave if

    }



    @Override
    public void init() throws Exception {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root2;
                try{
                   root2= FXMLLoader.load(getClass().getResource("splash.fxml"));
                   scene=new Scene(root2,900,600);
                }catch (IOException e){
                    e.printStackTrace();
                }//Llave catch
            }//Llave run()

        });
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage=primaryStage;
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setScene(scene);
        this.stage.show();
        lblProgress=(Label) scene.lookup("#lblProg");
        barra=(ProgressBar) scene.lookup("#prog");

    }



}//Llave Splash
