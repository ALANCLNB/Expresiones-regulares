package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    @FXML
    TextField txtExpresion;
    @FXML
    Label lblResultado;
    @FXML
    ListView lista;
String[]arr={

        "\\w{2,4}",
        "([A-Z]{1}[a-z])+||([a-z]+[A-Z]{1})+||([a-z]+[A-Z]{1})",
        "^[A-Z][a-z0-9]+",
        "^[^db]\\w+",
        "\\w+[count]$",
        "\\w+\\s\\w+",



        "\\w{2}[:]\\w{2}[:]\\w{2}[:]\\w{2}[:]\\w{2}[:]\\w{2}",////////////
        "[A-Z][\\w]+[A-Z]",
        "[0-1]{8}",
        "[A-F0-9]{6}",
        "[0-9][/|*|-|+][0-9]",
        "[1-9][0-9][CG][0-9]{4}",
        "[A-Z]{4}[0-9]{6}[A-Z]{6}[0-9]{2}",


        "\\d+[.]\\d{2}mxn$",

        "[0-9]{16}",

        "^[<]\\w+[>]$",

        "[A-F0-9]{6}",

        "https://\\w+\\.com$",

        "INSERT INTO \\w+[(]\\w[)] VALUES [(]\\w+[)]",

        "if[(]\\w+[==||<||>||=!]\\w+[)][{]\\w+[}]",

        "\\w+?\\\\n?\\w+",/////////////

        "https://www\\.youtube\\.com/watch\\?v=\\w{11}$"


};



    @FXML protected void initialize(){
     ObservableList<String> datos= FXCollections.observableArrayList();
     datos.add("Mínimo 2 máximo 4");
     datos.add("Mayuscula sin número");
     datos.add("Mayuscula con número");
     datos.add("Palabra que no comience con db-");
     datos.add("Palabra que termine con count");
     datos.add("Que hayan escrito dos nombres");


     datos.add("Que hayan una direccion MAC");
     datos.add("Que una palabra comience y termine con Mayus");
     datos.add("Numero binario de 8 digitos");
        datos.add("Escrito correctamente un numero hexadecimal");
        datos.add("Operacion  de 1 digito");
        datos.add("Que se ingrese el No.Control Correctamente");
        datos.add("Que se ingrese la CURP Correctamente");


        datos.add("X cantidad de pesos $19.50mxn");
        datos.add("Numero de targeta");
        datos.add("Etiqueta HTML");
        datos.add("Color hexadecimal");
        datos.add("Link");
        datos.add("uery INSERT INTO SQL");
        datos.add("Sentencia IF de X variable con X xondicion ");
        datos.add("Validar que se haya escrito una frase con salto de linea");
        datos.add("Validar que se haya escrito una url con un video de youtube");

            lista.setItems(datos);
            }//Llave cuando cargan


    public void evento(KeyEvent event){
        if(event.getCode()== KeyCode.ENTER){

            Pattern patron =Pattern.compile(arr[lista.getSelectionModel().getSelectedIndex()]);
            Matcher mat=patron.matcher(txtExpresion.getText());

            if(mat.matches()==true){
                lblResultado.setText("Si comple");
            }else{
                lblResultado.setText("No cumple");
            }//Llave if

           ;

        }//Llave if

    }//La



}
