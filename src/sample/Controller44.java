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

public class Controller44 {

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
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button13;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Button button23;

    @FXML
    private Button button30;

    @FXML
    private Button button31;

    @FXML
    private Button button32;

    @FXML
    private Button button33;

    //создаем картинки
    Image nol = new Image(getClass().getResourceAsStream("/sample/image/nol.png"));
    Image krest = new Image(getClass().getResourceAsStream("/sample/image/krest.png"));

    //размер поля
    int FIELD_SIZE = 4;

    //массив всех кнопок
    Button [][] mass = new Button[FIELD_SIZE][FIELD_SIZE];

    //массив значений кнопок (1 - крест, 2 - ноль, 0 - пусто)
    int [][] massValue = new int[FIELD_SIZE][FIELD_SIZE];

    //глобальные копии потоков  для обмена с сервером
    Socket clientSocketGlobal;
    OutputStreamWriter streamWriter;
    BufferedReader streamReader;

    //глобальыне переменные, которые хранят адрес только что нажатой кнопки
    int tempI, tempJ;





    void listener() {

        boolean isEndGame = true; //флаг конца игры (изначально ставим тру, в цикле если найдем хоть одну пустую клетку, меняем)

        //проверяем остались ли в массиве свободные кнопки
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (massValue[i][j] == 0) {
                    isEndGame = false;
                    break;
                }
            }

        //переменные для хранения максимальных значений по строкам столбцам и диагоналям
        int lengthKrestStr = 0, lengthNolStr = 0, lengthKrestStb = 0, lengthNolStb = 0, lengthKrestDiag = 0, lengthNolDiag = 0;

        //действия в зависимости от того, остались ли клетки
        if (isEndGame)
        {
            //проверка строк
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

            //проверка столбцов
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

            //проверка диагоналей
            //главная большая диагональ
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

            //побочная большая диагональ
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


            // справа налево сверху вниз от главной диагонали
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


            //слева направо снизу вверх от главной диагонали
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


            // справа налево снизу вверх от побочной диагонали
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


            //слева направо сверху вниз от побочной диагонали
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

            //проверка завершена переменные хранят максимальные значения
            int maxNol = Math.max(Math.max(lengthNolStr, lengthNolStb), lengthNolDiag);
            int maxKrest = Math.max(Math.max(lengthKrestStr, lengthKrestStb), lengthKrestDiag);

            //вывод формы с результатом
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
            //отправляем данные о ходе
            try {
                streamWriter.write(tempI + "\n");
                streamWriter.write(tempJ + "\n");
                streamWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //получаем ход сервера
            try {
                tempI = Integer.parseInt(streamReader.readLine());
                tempJ = Integer.parseInt(streamReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            massValue[tempI][tempJ] = 2;

            //отображение хода компьютера
            ImageView noll = new ImageView(nol);
            noll.setFitWidth(100);
            noll.setFitHeight(100);
            mass[tempI][tempJ].graphicProperty().setValue(noll);
            mass[tempI][tempJ].setDisable(true);

            //проверка остались ли свободные клетки
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

        //Заполняем массив кнопок
        mass[0][0] = button00;
        mass[0][1] = button01;
        mass[0][2] = button02;
        mass[0][3] = button03;
        mass[1][0] = button10;
        mass[1][1] = button11;
        mass[1][2] = button12;
        mass[1][3] = button13;
        mass[2][0] = button20;
        mass[2][1] = button21;
        mass[2][2] = button22;
        mass[2][3] = button23;
        mass[3][0] = button30;
        mass[3][1] = button31;
        mass[3][2] = button32;
        mass[3][3] = button33;

        //создание сокета
        Socket clientSocket = new Socket("127.0.0.1", 8080);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        //присваивание глобальным переменным значений
        clientSocketGlobal = clientSocket;
        streamWriter = writer;
        streamReader = reader;

        //сообщаем серверу о размерности поля
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

            // скрываем текущее окно
            exitButton.getScene().getWindow().hide();
            //запускаем нужное окно
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

        //Задаем обработчик нажатия каждой кнопке в цикле
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                int ii = i, jj = j;

                mass[i][j].setOnAction(actionEvent -> {

                    ImageView krestt = new ImageView(krest);
                    krestt.setFitWidth(100);
                    krestt.setFitHeight(100);
                    //ходит игрок
                    mass[ii][jj].graphicProperty().setValue(krestt);
                    mass[ii][jj].setDisable(true);
                    massValue[ii][jj] = 1;

                    // запоминаем нажатую кнопку
                    tempI = ii;
                    tempJ = jj;

                    // запускаем метод, выполняющийся после каждого хода игрока
                    listener();
                });

                //инициализация массива значений
                massValue[i][j] = 0;
            }

    }

}
