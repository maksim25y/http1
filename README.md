Данный проект я выполнял при изучении HTTP, представляет из себя веб-приложение, в котором есть следующие возможности:

Регистрация
![image](https://github.com/maksim25y/http1/assets/131711956/5f6e4a11-9820-4e6b-8655-e0db957fd9bc)
При нажатии происходит запрос на сервлет /registration, пользователь может ввести данные, после чего происходит добавление информации о пользователе в Базу данных, если пользователь не был зарегистрирован ранее.

Пользователю необходимо заполнить следующие поля для регистрации:
![image](https://github.com/maksim25y/http1/assets/131711956/50c8d845-7ab6-47ed-9b4a-cd420244bfcb)

Почта, которую вводит пользователь должна быть уникальной. Если пользователь введет какие-либо данные некорректно регистрация не пройдет.
При успешной регистрации произойдет переадресация на страницу авторизации по почте и паролю, которые пользователь указал при регистрации. (На данную страницу также можно попасть, нажав на кнопку в хэдере).
![image](https://github.com/maksim25y/http1/assets/131711956/5021b3f3-a6ef-4ed3-8032-b94dcb9f9717)

Если пароль или почта, введенные пользователем не совпадают со значениями в БД, то будет выведено сообщение об ошибке:
![image](https://github.com/maksim25y/http1/assets/131711956/6e560ba0-4753-46fa-b781-28905e4b9b3f)

При удачной авторизации пользователь попадает на страницу с перелетами внутри авиакомпании (информация о перелетах берется из БД). 
Данная страница доступна только авторизированным пользователям. 
Есть возможность сделать фильтрацию, а именно указать 2 параметра (начальная точка маршрута - конечная точка маршрута, в обоих случаях указываются коды аэропортов).
![image](https://github.com/maksim25y/http1/assets/131711956/b2cfe2a9-d6fd-4528-be85-f56ebff4a230)
Фильтр по следуюшим параметрам (LDN-BSL):
![image](https://github.com/maksim25y/http1/assets/131711956/e08b0f93-fb13-4c69-81bf-2871c9134112)
В случае ввода некорректных данных от пользователя или отсутсвии рейсов по заданным параметрам будет выведено соответствующее сообщение:
![image](https://github.com/maksim25y/http1/assets/131711956/953dcb55-a476-43c2-971e-c735509f2550)












