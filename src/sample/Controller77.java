package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Controller77 {

    @FXML
    private Button exitButton;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button03;

    @FXML
    private Button button04;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button13;

    @FXML
    private Button button14;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Button button23;

    @FXML
    private Button button24;

    @FXML
    private Button button30;

    @FXML
    private Button button31;

    @FXML
    private Button button32;

    @FXML
    private Button button33;

    @FXML
    private Button button34;

    @FXML
    private Button button40;

    @FXML
    private Button button41;

    @FXML
    private Button button42;

    @FXML
    private Button button43;

    @FXML
    private Button button44;

    @FXML
    private Button button15;

    @FXML
    private Button button16;

    @FXML
    private Button button25;

    @FXML
    private Button button35;

    @FXML
    private Button button26;

    @FXML
    private Button button45;

    @FXML
    private Button button36;

    @FXML
    private Button button46;

    @FXML
    private Button button51;

    @FXML
    private Button button50;

    @FXML
    private Button button52;

    @FXML
    private Button button53;

    @FXML
    private Button button54;

    @FXML
    private Button button55;

    @FXML
    private Button button56;

    @FXML
    private Button button60;

    @FXML
    private Button button61;

    @FXML
    private Button button62;

    @FXML
    private Button button63;

    @FXML
    private Button button64;

    @FXML
    private Button button65;

    @FXML
    private Button button66;

    @FXML
    private Button button05;

    @FXML
    private Button button06;

    //?????????????? ????????????????
    Image nol = new Image(getClass().getResourceAsStream("/sample/image/nol.png"));
    Image krest = new Image(getClass().getResourceAsStream("/sample/image/krest.png"));

    //???????????? ????????
    int FIELD_SIZE = 7;

    //???????????? ???????? ????????????
    Button [][] mass = new Button[FIELD_SIZE][FIELD_SIZE];

    //???????????? ???????????????? ???????????? (1 - ??????????, 2 - ????????, 0 - ??????????)
    int [][] massValue = new int[FIELD_SIZE][FIELD_SIZE];

    //???????????????????? ?????????? ??????????????  ?????? ???????????? ?? ????????????????
    Socket clientSocketGlobal;
    OutputStreamWriter streamWriter;
    BufferedReader streamReader;

    //???????????????????? ????????????????????, ?????????????? ???????????? ?????????? ???????????? ?????? ?????????????? ????????????
    int tempI, tempJ;





    void listener() {

        boolean isEndGame = true; //???????? ?????????? ???????? (???????????????????? ???????????? ??????, ?? ?????????? ???????? ???????????? ???????? ???????? ???????????? ????????????, ????????????)

        //?????????????????? ???????????????? ???? ?? ?????????????? ?????????????????? ????????????
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (massValue[i][j] == 0) {
                    isEndGame = false;
                    break;
                }
            }

        //???????????????????? ?????? ???????????????? ???????????????????????? ???????????????? ???? ?????????????? ???????????????? ?? ????????????????????
        int lengthKrestStr = 0, lengthNolStr = 0, lengthKrestStb = 0, lengthNolStb = 0, lengthKrestDiag = 0, lengthNolDiag = 0;

        //???????????????? ?? ?????????????????????? ???? ????????, ???????????????? ???? ????????????
        if (isEndGame)
        {
            //???????????????? ??????????
            for (int i = 0; i < FIELD_SIZE; i++)
            {
                int tempLengthKrest = 0, tempLengthNol = 0;
                for (int j = 0; j < FIELD_SIZE; j++)
                {

                    if (massValue[i][j] == 1)
                    {
                        lengthNolStr = Math.max(lengthNolStr, tempLengthNol);
                        tempLengthNol = 0;
                        tempLengthKrest ++;
                        if (j == FIELD_SIZE - 1) {
                            lengthKrestStr = Math.max(lengthKrestStr, tempLengthKrest);
                            tempLengthKrest = 0;
                        }
                    }
                    else
                    {
                        lengthKrestStr = Math.max(lengthKrestStr, tempLengthKrest);
                        tempLengthKrest = 0;
                        tempLengthNol ++;
                        if (j == FIELD_SIZE - 1) {
                            lengthNolStr = Math.max(lengthNolStr, tempLengthNol);
                            tempLengthNol = 0;
                        }
                    }
                }
            }

            //???????????????? ????????????????
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                int tempLengthKrest = 0, tempLengthNol = 0;
                for (int i = 0; i < FIELD_SIZE; i++)
                {

                    if (massValue[i][j] == 1)
                    {
                        lengthNolStb = Math.max(lengthNolStb, tempLengthNol);
                        tempLengthNol = 0;
                        tempLengthKrest ++;
                        if (i == FIELD_SIZE - 1) {
                            lengthKrestStb = Math.max(lengthKrestStb, tempLengthKrest);
                            tempLengthKrest = 0;
                        }
                    }
                    else
                    {
                        lengthKrestStb = Math.max(lengthKrestStb, tempLengthKrest);
                        tempLengthKrest = 0;
                        tempLengthNol ++;
                        if (i == FIELD_SIZE - 1) {
                            lengthNolStb = Math.max(lengthNolStb, tempLengthNol);
                            tempLengthNol = 0;
                        }
                    }
                }
            }

            //???????????????? ????????????????????
            //?????????????? ?????????????? ??????????????????
            int tempLengthKrest = 0, tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE; i++)
            {
                if (massValue[i][i] == 1)
                {
                    lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                    tempLengthNol = 0;
                    tempLengthKrest ++;
                    if (i == FIELD_SIZE - 1) {
                        lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                        tempLengthKrest = 0;
                    }

                }
                else
                {
                    lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                    tempLengthKrest = 0;
                    tempLengthNol ++;
                    if (i == FIELD_SIZE - 1) {
                        lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                        tempLengthNol = 0;
                    }
                }
            }

            //???????????????? ?????????????? ??????????????????
            tempLengthKrest = 0; tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE; i++)
            {
                if (massValue[FIELD_SIZE - 1 - i][i] == 1)
                {
                    lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                    tempLengthNol = 0;
                    tempLengthKrest ++;
                    if (i == FIELD_SIZE - 1) {
                        lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                        tempLengthKrest = 0;
                    }
                }
                else
                {
                    lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                    tempLengthKrest = 0;
                    tempLengthNol ++;
                    if (i == FIELD_SIZE - 1) {
                        lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                        tempLengthNol = 0;
                    }
                }
            }


            // ???????????? ???????????? ???????????? ???????? ???? ?????????????? ??????????????????
            tempLengthKrest = 0; tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE - 2; i++)
            {
                for (int ii = 1 + i; ii < FIELD_SIZE; ii++)
                {
                    for (int j = 0; j < FIELD_SIZE - ii; j++)
                    {
                        if (massValue[ii + j][j] == 1)
                        {
                            lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                            tempLengthNol = 0;
                            tempLengthKrest ++;
                            if (j == FIELD_SIZE - ii - 1) {
                                lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                                tempLengthKrest = 0;
                            }
                        }
                        else
                        {
                            lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                            tempLengthKrest = 0;
                            tempLengthNol ++;
                            if (j == FIELD_SIZE - ii - 1) {
                                lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                                tempLengthNol = 0;
                            }
                        }
                    }
                }
            }


            //?????????? ?????????????? ?????????? ?????????? ???? ?????????????? ??????????????????
            tempLengthKrest = 0; tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE - 2; i++)
            {
                for (int ii = 0; ii < FIELD_SIZE - 1 - i; ii++)
                {
                    for (int j = i + 1; j < FIELD_SIZE; j++)
                    {
                        if (massValue[j - 1 - i][j] == 1)
                        {
                            lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                            tempLengthNol = 0;
                            tempLengthKrest ++;
                            if (j == FIELD_SIZE - 1) {
                                lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                                tempLengthKrest = 0;
                            }
                        }
                        else
                        {
                            lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                            tempLengthKrest = 0;
                            tempLengthNol ++;
                            if (j == FIELD_SIZE - 1) {
                                lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                                tempLengthNol = 0;
                            }
                        }
                    }
                }
            }


            // ???????????? ???????????? ?????????? ?????????? ???? ???????????????? ??????????????????
            tempLengthKrest = 0; tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE - 2; i++)
            {
                for (int ii = FIELD_SIZE - 2 - i; ii >= 0; ii--)
                {
                    for (int j = 0; j <= ii; j++)
                    {
                        if (massValue[ii - j][j] == 1)
                        {
                            lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                            tempLengthNol = 0;
                            tempLengthKrest ++;
                            if (j == ii) {
                                lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                                tempLengthKrest = 0;
                            }
                        }
                        else
                        {
                            lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                            tempLengthKrest = 0;
                            tempLengthNol ++;
                            if (j == ii) {
                                lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                                tempLengthNol = 0;
                            }
                        }
                    }
                }
            }


            //?????????? ?????????????? ???????????? ???????? ???? ???????????????? ??????????????????
            tempLengthKrest = 0; tempLengthNol = 0;
            for (int i = 0; i < FIELD_SIZE - 2; i ++)
            {
                for (int ii = FIELD_SIZE - 1; ii > i; ii--)
                {
                    for (int j = i + 1; j < FIELD_SIZE; j++)
                    {
                        if (massValue[FIELD_SIZE - j + i][j] == 1)
                        {
                            lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                            tempLengthNol = 0;
                            tempLengthKrest ++;
                            if (j == FIELD_SIZE - 1) {
                                lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                                tempLengthKrest = 0;
                            }
                        }
                        else
                        {
                            lengthKrestDiag = Math.max(lengthKrestDiag, tempLengthKrest);
                            tempLengthKrest = 0;
                            tempLengthNol ++;
                            if (j == FIELD_SIZE - 1) {
                                lengthNolDiag = Math.max(lengthNolDiag, tempLengthNol);
                                tempLengthNol = 0;
                            }
                        }
                    }
                }
            }

            //???????????????? ?????????????????? ???????????????????? ???????????? ???????????????????????? ????????????????
            int maxNol = Math.max(Math.max(lengthNolStr, lengthNolStb), lengthNolDiag);
            int maxKrest = Math.max(Math.max(lengthKrestStr, lengthKrestStb), lengthKrestDiag);

            //?????????? ?????????? ?? ??????????????????????
            if (maxKrest > maxNol)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/winForm.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else if (maxNol > maxKrest)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/loseForm.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/drawForm.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            try {
                streamReader.close();
                streamWriter.close();
                clientSocketGlobal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            //???????????????????? ???????????? ?? ????????
            try {
                streamWriter.write(tempI + "\n");
                streamWriter.write(tempJ + "\n");
                streamWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //???????????????? ?????? ??????????????
            try {
                tempI = Integer.parseInt(streamReader.readLine());
                tempJ = Integer.parseInt(streamReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            massValue[tempI][tempJ] = 2;

            //?????????????????????? ???????? ????????????????????
            ImageView noll = new ImageView(nol);
            noll.setFitWidth(50);
            noll.setFitHeight(50);
            mass[tempI][tempJ].graphicProperty().setValue(noll);
            mass[tempI][tempJ].setDisable(true);

            //???????????????? ???????????????? ???? ?????????????????? ????????????
            isEndGame = true;
            for (int i = 0; i < FIELD_SIZE; i++)
                for (int j = 0; j < FIELD_SIZE; j++)
                {
                    if (massValue[i][j] == 0) {
                        isEndGame = false;
                        break;
                    }
                }
            if (isEndGame)
                listener();
        }
    }

    @FXML
    void initialize() throws IOException {

        //?????????????????? ???????????? ????????????
        mass[0][0] = button00;
        mass[0][1] = button01;
        mass[0][2] = button02;
        mass[0][3] = button03;
        mass[0][4] = button04;
        mass[0][5] = button05;
        mass[0][6] = button06;
        mass[1][0] = button10;
        mass[1][1] = button11;
        mass[1][2] = button12;
        mass[1][3] = button13;
        mass[1][4] = button14;
        mass[1][5] = button15;
        mass[1][6] = button16;
        mass[2][0] = button20;
        mass[2][1] = button21;
        mass[2][2] = button22;
        mass[2][3] = button23;
        mass[2][4] = button24;
        mass[2][5] = button25;
        mass[2][6] = button26;
        mass[3][0] = button30;
        mass[3][1] = button31;
        mass[3][2] = button32;
        mass[3][3] = button33;
        mass[3][4] = button34;
        mass[3][5] = button35;
        mass[3][6] = button36;
        mass[4][0] = button40;
        mass[4][1] = button41;
        mass[4][2] = button42;
        mass[4][3] = button43;
        mass[4][4] = button44;
        mass[4][5] = button45;
        mass[4][6] = button46;
        mass[5][0] = button50;
        mass[5][1] = button51;
        mass[5][2] = button52;
        mass[5][3] = button53;
        mass[5][4] = button54;
        mass[5][5] = button55;
        mass[5][6] = button56;
        mass[6][0] = button60;
        mass[6][1] = button61;
        mass[6][2] = button62;
        mass[6][3] = button63;
        mass[6][4] = button64;
        mass[6][5] = button65;
        mass[6][6] = button66;


        //???????????????? ????????????
        Socket clientSocket = new Socket("127.0.0.1", 8080);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        //???????????????????????? ???????????????????? ???????????????????? ????????????????
        clientSocketGlobal = clientSocket;
        streamWriter = writer;
        streamReader = reader;

        //???????????????? ?????????????? ?? ?????????????????????? ????????
        writer.write(FIELD_SIZE + "\n");
        writer.flush();



        exitButton.setOnAction(actionEvent -> {

            try {
                streamWriter.write(666 + "\n");
                streamWriter.flush();
                streamReader.close();
                streamWriter.close();
                clientSocketGlobal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // ???????????????? ?????????????? ????????
            exitButton.getScene().getWindow().hide();
            //?????????????????? ???????????? ????????
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/MainForm.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        //???????????? ???????????????????? ?????????????? ???????????? ???????????? ?? ??????????
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                int ii = i, jj = j;

                mass[i][j].setOnAction(actionEvent -> {

                    ImageView krestt = new ImageView(krest);
                    krestt.setFitWidth(50);
                    krestt.setFitHeight(50);
                    //?????????? ??????????
                    mass[ii][jj].graphicProperty().setValue(krestt);
                    mass[ii][jj].setDisable(true);
                    massValue[ii][jj] = 1;

                    // ???????????????????? ?????????????? ????????????
                    tempI = ii;
                    tempJ = jj;

                    // ?????????????????? ??????????, ?????????????????????????? ?????????? ?????????????? ???????? ????????????
                    listener();
                });

                //?????????????????????????? ?????????????? ????????????????
                massValue[i][j] = 0;
            }
    }

}
