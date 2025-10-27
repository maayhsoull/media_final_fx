package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        stage.setHeight(500);

        //determinar o título do stage (tela/janela)
        stage.setTitle("Média Final");

        //painel raiz (root)
        BorderPane root = new BorderPane();

        //Texto principal
        Label labelTitulo = new Label();
        labelTitulo.setText("Escola \"Prof. Vicente Amato\"");
        //formatação do texto da label
        labelTitulo.setStyle("-fx-text-fill: #FF2900; -fx-font-size: 32; -fx-font-weight: bold");
        labelTitulo.setPadding(new Insets(10, 0, 10, 10));


        //painel de resultados - parte de baixo
        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets(0, 0, 10, 10));
        Label labelAluno = new Label("Nome do Aluno:");
        Label labelMediafinal = new Label("Média Final:");
        Label labelSituacao = new Label("Situação:");
        painelResultado.getChildren().addAll(labelAluno, labelMediafinal, labelSituacao);

        //painel de botoes
        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets(50, 80, 10, 0));
        painelDeBotoes.setSpacing(20);
        Button buttonCalcularMedia = new Button("Calcular Média");
        buttonCalcularMedia.setPrefWidth(120);
        buttonCalcularMedia.setPrefHeight(30);
        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(120);
        buttonLimpar.setPrefHeight(30);
        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(120);
        buttonSair.setPrefHeight(30);
        painelDeBotoes.getChildren().addAll(buttonCalcularMedia, buttonLimpar, buttonSair);

        //painel de formulario, inserir dados
        VBox painelDeFormulario = new VBox();
        painelDeFormulario.setPadding(new Insets(0, 0, 10, 10));
        Label labelNomeAluno = new Label("Nome do Aluno");
        Label labelNota1 = new Label("Nota 1:");
        Label labelNota2 = new Label("Nota 2:");
        Label labelNota3 = new Label("Nota 3:");
        Label labelNota4 = new Label("Nota 4:");
        TextField textFieldNome = new TextField();
        TextField textFieldNota1 = new TextField();
        TextField textFieldNota2 = new TextField();
        TextField textFieldNota3 = new TextField();
        TextField textFieldNota4 = new TextField();
        painelDeFormulario.getChildren().addAll(
                labelNomeAluno, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4
        );

        root.setTop(labelTitulo);
        root.setBottom(painelResultado);
        root.setRight(painelDeBotoes);
        root.setLeft(painelDeFormulario);

        Scene scene = new Scene(root);

        stage.setScene(scene);

        //mostrar o stage (tela)
        stage.show();

        //eventos de click dos botoes
        //função lambda ou arrow function, função de seta.
        buttonCalcularMedia.setOnAction(click ->{
            System.out.println("Botão clicado!");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do Aluno: " + nomeDigitado);

            // CALCULAR MEDIA
            //OBTER AS NOTAS
            //transforma uma string em double
            String nota1Str = textFieldNota1.getText();
            double nota1 = Double.parseDouble(nota1Str);

            String nota2Str = textFieldNota2.getText();
            double nota2 = Double.parseDouble(nota2Str);

            String nota3Str = textFieldNota3.getText();
            double nota3 = Double.parseDouble(nota3Str);

            String nota4Str = textFieldNota4.getText();
            double nota4 = Double.parseDouble(nota4Str);

            double mediaFinal = (nota1 + nota2 + nota3 + nota4) / 4;

            //formatação para 2 zeros após a virgula
            String mediaFinalStr = String.format("%.2f", mediaFinal);
            labelMediafinal.setText("Média final: " + mediaFinalStr);

            //Realizando logica para verificar a situação
            String situacao = "";

            if (mediaFinal < 4){
                situacao = "REPROVADO";
            } else if (mediaFinal >= 6) {
                situacao = "APROVADO";
            } else  {
                situacao = "RECUPERAÇÃO";
            }

            labelSituacao.setText("Situação: " + situacao);


        });
    }
}
