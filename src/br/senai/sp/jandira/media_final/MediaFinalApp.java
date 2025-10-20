package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //determinar o tamanho do stage
        stage.setWidth(600);
        stage.setHeight(400);

        //determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //painel raiz (root)
        BorderPane root = new BorderPane();

        //Texto principal
        Label labelTitulo = new Label();
        labelTitulo.setText("Escola: Prof. Vicente Amato");

        //painel de resultados - parte de baixo
        VBox painelResultado = new VBox();
        Label labelAluno = new Label("Nome do Aluno:");
        Label labelMedia = new Label("Média Final:");
        Label labelSituacao = new Label("Situação:");

        //painel de botoes
        VBox painelDeBotoes = new VBox();
        Button buttonCalcularMedia = new Button("Calcular Média");
        Button buttonLimpar = new Button("Limpar");
        Button buttonSair = new Button("Sair");

        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);
        painelResultado.getChildren().addAll(labelAluno, labelMedia, labelSituacao);


        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);

        Scene scene = new Scene(root);

        stage.setScene(scene);




        //mostrar o stage (tela)
        stage.show();
    }
}
