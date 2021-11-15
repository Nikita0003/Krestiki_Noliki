package sample;

import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        int sizeField; //размер игрового поля
        int [][] massValue;

        // общий цикл, в котором может провестись сколько угодно  игр
        while (true)
        {
            Socket clientSocket = serverSocket.accept();
            System.out.println("произошло подключение");

            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("1");

            sizeField = Integer.parseInt(reader.readLine());
            System.out.println("2");
            massValue = new int[sizeField][sizeField];

            //инициализация массива значений
            for (int i = 0; i < sizeField; i++)
                for (int j = 0; j < sizeField; j++)
                {
                    massValue[i][j] = 0;
                }
            System.out.println("3");
            //цикл только для одной игры с конкретной размерностью поля
            while (true)
            {
                //принимаем ход игрока
                int tempI = Integer.parseInt(reader.readLine());
                if (tempI == 666)
                    break;
                int tempJ = Integer.parseInt(reader.readLine());

                //записываем в нужную ячейку крест
                massValue[tempI][tempJ] = 1;

                //считаем количесвто пустых клеток
                int tempNumberOfEmptyButton = 0;

                for (int i = 0; i < sizeField; i++)
                {
                    for (int j = 0; j < sizeField; j++)
                    {
                        if (massValue[i][j] == 0)
                            tempNumberOfEmptyButton++;
                    }
                }

                // выбираем случайную кнопку из свободных
                int rand =  (int) (Math.random() * tempNumberOfEmptyButton);

                for (int i = 0; i < sizeField; i++)
                {
                    for (int j = 0; j < sizeField; j++)
                    {
                        if (massValue[i][j] == 0)
                        {
                            if (rand == 0)
                            {
                                massValue[i][j] = 2;
                                tempI = i;
                                tempJ = j;
                                rand = -1; //чисто на всякий случай
                                break;
                            }
                            else
                            {
                                rand--;
                            }
                        }
                    }
                }

                //считаем количесвто пустых клеток
                tempNumberOfEmptyButton = 0;

                for (int i = 0; i < sizeField; i++)
                {
                    for (int j = 0; j < sizeField; j++)
                    {
                        if (massValue[i][j] == 0)
                            tempNumberOfEmptyButton++;
                    }
                }

                writer.write(tempI + "\n");
                writer.write(tempJ + "\n");
                writer.flush();
                if (tempNumberOfEmptyButton == 0 || tempNumberOfEmptyButton == 1)
                    break;
            }
        }

    }

}

