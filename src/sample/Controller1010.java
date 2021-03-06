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

public class Controller1010 {

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
    private Button button07;

    @FXML
    private Button button17;

    @FXML
    private Button button27;

    @FXML
    private Button button37;

    @FXML
    private Button button47;

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
    private Button button57;

    @FXML
    private Button button58;

    @FXML
    private Button button48;

    @FXML
    private Button button38;

    @FXML
    private Button button28;

    @FXML
    private Button button18;

    @FXML
    private Button button08;

    @FXML
    private Button button09;

    @FXML
    private Button button19;

    @FXML
    private Button button29;

    @FXML
    private Button button39;

    @FXML
    private Button button49;

    @FXML
    private Button button59;

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
    private Button button67;

    @FXML
    private Button button68;

    @FXML
    private Button button69;

    @FXML
    private Button button70;

    @FXML
    private Button button71;

    @FXML
    private Button button72;

    @FXML
    private Button button73;

    @FXML
    private Button button74;

    @FXML
    private Button button75;

    @FXML
    private Button button76;

    @FXML
    private Button button77;

    @FXML
    private Button button78;

    @FXML
    private Button button79;

    @FXML
    private Button button80;

    @FXML
    private Button button81;

    @FXML
    private Button button82;

    @FXML
    private Button button83;

    @FXML
    private Button button84;

    @FXML
    private Button button85;

    @FXML
    private Button button86;

    @FXML
    private Button button87;

    @FXML
    private Button button88;

    @FXML
    private Button button89;

    @FXML
    private Button button90;

    @FXML
    private Button button91;

    @FXML
    private Button button92;

    @FXML
    private Button button93;

    @FXML
    private Button button94;

    @FXML
    private Button button95;

    @FXML
    private Button button96;

    @FXML
    private Button button97;

    @FXML
    private Button button98;

    @FXML
    private Button button99;

    @FXML
    private Button button05;

    @FXML
    private Button button06;

    //?????????????? ????????????????
    Image nol = new Image(getClass().getResourceAsStream("/sample/image/nol.png"));
    Image krest = new Image(getClass().getResourceAsStream("/sample/image/krest.png"));

    //???????????? ????????
    int FIELD_SIZE = 10;

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
            noll.setFitWidth(30);
            noll.setFitHeight(30);
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
        mass[0][7] = button07;
        mass[0][8] = button08;
        mass[0][9] = button09;
        mass[1][0] = button10;
        mass[1][1] = button11;
        mass[1][2] = button12;
        mass[1][3] = button13;
        mass[1][4] = button14;
        mass[1][5] = button15;
        mass[1][6] = button16;
        mass[1][7] = button17;
        mass[1][8] = button18;
        mass[1][9] = button19;
        mass[2][0] = button20;
        mass[2][1] = button21;
        mass[2][2] = button22;
        mass[2][3] = button23;
        mass[2][4] = button24;
        mass[2][5] = button25;
        mass[2][6] = button26;
        mass[2][7] = button27;
        mass[2][8] = button28;
        mass[2][9] = button29;
        mass[3][0] = button30;
        mass[3][1] = button31;
        mass[3][2] = button32;
        mass[3][3] = button33;
        mass[3][4] = button34;
        mass[3][5] = button35;
        mass[3][6] = button36;
        mass[3][7] = button37;
        mass[3][8] = button38;
        mass[3][9] = button39;
        mass[4][0] = button40;
        mass[4][1] = button41;
        mass[4][2] = button42;
        mass[4][3] = button43;
        mass[4][4] = button44;
        mass[4][5] = button45;
        mass[4][6] = button46;
        mass[4][7] = button47;
        mass[4][8] = button48;
        mass[4][9] = button49;
        mass[5][0] = button50;
        mass[5][1] = button51;
        mass[5][2] = button52;
        mass[5][3] = button53;
        mass[5][4] = button54;
        mass[5][5] = button55;
        mass[5][6] = button56;
        mass[5][7] = button57;
        mass[5][8] = button58;
        mass[5][9] = button59;
        mass[6][0] = button60;
        mass[6][1] = button61;
        mass[6][2] = button62;
        mass[6][3] = button63;
        mass[6][4] = button64;
        mass[6][5] = button65;
        mass[6][6] = button66;
        mass[6][7] = button67;
        mass[6][8] = button68;
        mass[6][9] = button69;
        mass[7][0] = button70;
        mass[7][1] = button71;
        mass[7][2] = button72;
        mass[7][3] = button73;
        mass[7][4] = button74;
        mass[7][5] = button75;
        mass[7][6] = button76;
        mass[7][7] = button77;
        mass[7][8] = button78;
        mass[7][9] = button79;
        mass[8][0] = button80;
        mass[8][1] = button81;
        mass[8][2] = button82;
        mass[8][3] = button83;
        mass[8][4] = button84;
        mass[8][5] = button85;
        mass[8][6] = button86;
        mass[8][7] = button87;
        mass[8][8] = button88;
        mass[8][9] = button89;
        mass[9][0] = button90;
        mass[9][1] = button91;
        mass[9][2] = button92;
        mass[9][3] = button93;
        mass[9][4] = button94;
        mass[9][5] = button95;
        mass[9][6] = button96;
        mass[9][7] = button97;
        mass[9][8] = button98;
        mass[9][9] = button99;

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
                    krestt.setFitWidth(30);
                    krestt.setFitHeight(30);
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
