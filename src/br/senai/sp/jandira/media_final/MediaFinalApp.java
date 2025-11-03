package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

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

            //criar um vetor de notas (array)
            //Realizando o cleancode, onde diminui uma variavel por um vetor que irá salvar todos os valores.
            double[] notas = new double[4];
            String notasStr[] = new String[4];

            //transforma uma string em double
            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] = textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3] = Double.parseDouble(notasStr[3]);

            //Uso de loop while (enquanto)

            int i = 0;

            double mediaFinal = 0.0;

            while (i < notas.length){
                //mediaFinal = mediaFinal + notas[i]; adicionando incremento na proxima linha trazer o operador
                //para antes do sinal de igualdade, assim evita repetições.
                mediaFinal += notas[i];
                //i = i + 1; adicionando incremento na proxima linha
                i++;
            }

            mediaFinal = mediaFinal / notas.length;

            //Alterado o numero setado para o vetor total. O .length utiliza o tamanho do array.
            //double mediaFinal = (notas[0] + notas[1] + notas[2] + notas[3]) / notas.length;

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

        //BOTÃO LIMPAR
        buttonLimpar.setOnAction(click -> {
            textFieldNome.clear();
            textFieldNota1.clear();
            textFieldNota2.clear();
            textFieldNota3.clear();
            textFieldNota4.clear();

            labelAluno.setText("Nome do Aluno:");
            labelMediafinal.setText("Média Final:");
            labelSituacao.setText("Situação:");
            textFieldNome.requestFocus();
        });

        //botão sair
        buttonSair.setOnAction(click -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION,"Confirma a saída?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> botaoPressionado = alerta.showAndWait();

            if (botaoPressionado.get() == ButtonType.YES){
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "Até logo!");
                alerta2.showAndWait();
                System.exit(0);
            }


        });


    }
}
