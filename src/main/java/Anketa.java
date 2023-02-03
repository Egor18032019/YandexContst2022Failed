import java.util.ArrayList;
import java.util.List;

public class Anketa {

    public static void main(String[] args) {


    }

    public void first() {
        int n = 5;
        List<Integer> lst = new ArrayList<>();
        boolean flag = true;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                lst.add(i);
            } else {
                flag = true;

            }
            System.out.println(lst);
        }
    }
}
/*
Используем флаг  boolean flag =true;
Задействуем 2 цикла;
Первый циклы берет все числа от 2 до числа n => переменная i
Во втором цикле берем все чиса от 2 до числа j => переменная j
И на каждой итерации второго цикла проверяем делится ли без остатка переменная i на j
Если делится то переводим флаг в положение false
прекращаем эту итерацию цикла j
и  идем на следующую итерацию цикла i

Если все прошло хорошо то увеличиваем счетчик на 1




CREATE TABLE IF NOT EXISTS `Cities` (

  `id` int(11) NOT NULL DEFAULT '0',

  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,

  `population` int(11) DEFAULT NULL,

  `founded` int(11) DEFAULT NULL,

  `country_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `Cities` (`id`, `name`, `population`, `founded`, `country_id`) VALUES

      (1, 'Ульяновск', 750000, 1648, 1),

      (2, 'Москва', 3000000, 1420, 1),

      (3, 'Ташкент', 2500000, 956, 2),

      (4, 'Урумчи', 900000, 205, 3),

      (5, 'Шанхай', 3000000, 20, 3);


CREATE TABLE IF NOT EXISTS `Companies` (

  `id` int(11) NOT NULL,

  `name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',

  `city_id` int(11) NOT NULL,

  `revenue` int(11) NOT NULL,

  `labors` int(11) NOT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `Companies` (`id`, `name`, `city_id`, `revenue`, `labors`) VALUES

      (1, 'Супер-софт', 1, 900000000, 1500),

      (2, 'Мегасофт', 1, 500000000, 3000),

      (3, 'Ковер-самолет', 3, 5000000, 3000),

      (4, 'Трах-Тибидох Development', 3, 1000000000, 5000),

      (5, 'Ур Ум Чи\'ка-1', 4, 300000, 1001),

      (6, 'Ур Ум Чи\'ка-2', 4, 520000, 999),

      (7, 'Пу До Нг', 5, 600000000, 1600),

      (8, 'ZBAA Dev', 5, 520000000, 2500),

      (9, 'IBS', 2, 500, 1200);


CREATE TABLE IF NOT EXISTS `Countries` (

  `id` int(11) NOT NULL AUTO_INCREMENT,

  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,

  `population` int(11) DEFAULT NULL,

  `gdp` bigint(20) DEFAULT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


INSERT INTO `Countries` (`id`, `name`, `population`, `gdp`) VALUES
      (1, 'Россия', 3000000, 500000000000),
      (2, 'Узбекистан', 1000001, 200000000000),
      (3, 'Китай', 1000000000, 1000000000000);


SELECT cou.name AS `Country`, COUNT(com.id)
      FROM Companies com
      LEFT JOIN Cities cit
      ON cit.id = com.city_id
      LEFT JOIN Countries cou
      ON cit.country_id = cou.id
WHERE  com.labors > 1000
GROUP BY cou.id

 */