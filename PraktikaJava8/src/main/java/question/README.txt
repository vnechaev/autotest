Здравствуйте, Павел!
Здравствуйте, Андрей!

    Я первоначально неправильно понял задание и попытался решить задачу
напрямую через потоки, у меня получилось(как мне кажется) создать канал
и сделать отправку сообщений, но я не смог придумать как
удовлетворить требование "Сообщения должны поступать в канал передачи
каждую секунду".
    Если Вас не затруднит, подскажите, пожалуйста, как это сделать.

С уважением студент Нечаев Всеволод


Вроде расписывал как нужно сделать. Повторю еще раз:

Значить смотри. Создаешь класс, который содержит одно поле private int id = this.hashCode() и геттер для этого поля. Потом создаешь класс потока (наследник от Thread) задача которого читать из источника (списка объектов) объекты и записывать их в PipedOutputStream через метод write(). Кстати тут можешь создать поле private List с объектами источника. Тут перед записью в PipedOutputStream ставишь задержку Thread.sleep(), как в задании. Потом создаешь второй класс потока (наследник от Thread) задача которого читать эти данные. Там чтения происходит из PipedInputStream с помощью метода read(). Можешь для наглядности выводить значение поля id этих объектов или добавь еще поле в объекты источника, чтобы посмотреть как происходит передача объектов по конвейеру.
Потом в основной программе (метод main) ты просто подключаешь стрим источника (PipedOutputStream) к стриму вывода (PipedInputStream) через метод connect. И запускаешь потоки (например через ExecutorService). Фишка всего этого в том, что твои потоки будут синхронизированые, так как PipedStreams синхронизированный и потоко безопасный. В общем эту задачку надо переделать через PipedStreams.

Если не получится вот никак, то на лекции сегодня покажу.
