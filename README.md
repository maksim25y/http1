Данный проект я выполнял при изучении HTTP, представляет из себя веб-приложение.
<details><summary>Функционал</summary>

Регистрация
![image](https://github.com/maksim25y/http1/assets/131711956/5f6e4a11-9820-4e6b-8655-e0db957fd9bc)
При нажатии происходит запрос на сервлет /registration, пользователь может ввести данные, после чего происходит добавление информации о пользователе в Базу данных, если пользователь не был зарегистрирован ранее.

Пользователю необходимо заполнить следующие поля для регистрации:
![image](https://github.com/maksim25y/http1/assets/131711956/50c8d845-7ab6-47ed-9b4a-cd420244bfcb)

Почта, которую вводит пользователь должна быть уникальной. Если пользователь введет какие-либо данные некорректно регистрация не пройдет.
При успешной регистрации произойдет переадресация на страницу входа в аккаунт по почте и паролю, которые пользователь указал при регистрации. (На данную страницу также можно попасть, нажав на кнопку в хэдере).
![image](https://github.com/maksim25y/http1/assets/131711956/5021b3f3-a6ef-4ed3-8032-b94dcb9f9717)

Если пароль или почта, введенные пользователем не совпадают со значениями в БД, то будет выведено сообщение об ошибке:
![image](https://github.com/maksim25y/http1/assets/131711956/6e560ba0-4753-46fa-b781-28905e4b9b3f)

При удачном входе пользователь попадает на страницу с перелетами внутри авиакомпании (информация о перелетах берется из БД). 
Данная страница доступна только пользователям, прошедшим аутентификацию. 
Есть возможность сделать фильтрацию, а именно указать 2 параметра (начальная точка маршрута - конечная точка маршрута, в обоих случаях указываются коды аэропортов).
![image](https://github.com/maksim25y/http1/assets/131711956/b2cfe2a9-d6fd-4528-be85-f56ebff4a230)
Фильтр по следуюшим параметрам (LDN-BSL):
![image](https://github.com/maksim25y/http1/assets/131711956/e08b0f93-fb13-4c69-81bf-2871c9134112)
В случае ввода некорректных данных от пользователя или отсутсвии рейсов по заданным параметрам будет выведено соответствующее сообщение:
![image](https://github.com/maksim25y/http1/assets/131711956/953dcb55-a476-43c2-971e-c735509f2550)
После успешного входа в аккаунт добавляется кнопка, при нажатии на которую происходит logout и пользователь выходит с аккаунта, происходит переадресация на страницу входа в аккаунт:

![image](https://github.com/maksim25y/http1/assets/131711956/f33d205f-dd80-4252-b774-8b70229c8089)

При нажатии на любой из перелетов будет доступна информация о билетах, купленных на данный рейс:
![image](https://github.com/maksim25y/http1/assets/131711956/c83ddb46-a498-4cd8-8b7e-75104bfe2ac4)
![image](https://github.com/maksim25y/http1/assets/131711956/285b79db-3628-4227-8020-1b5fcdf8d0ad)

Происходит переход на страницу /tickets?flightId=(id перелета).

Для смены пароля необходимо нажать на кнопку в хэдере:
![image](https://github.com/maksim25y/http1/assets/131711956/ca7d00da-2ce8-42e7-a811-84ad25ed41f9)

Необходимо ввести новый пароль, который будет сохранен в БД:
![image](https://github.com/maksim25y/http1/assets/131711956/ceaef347-23e6-4431-85bd-82a5c1241013)

На сайте есть возможность смены языков (английский и русский).
Для этого необходимо в хэдере выбрать нужный язык:
![image](https://github.com/maksim25y/http1/assets/131711956/61baa966-90b5-4efe-8132-49d78863e36c)

![image](https://github.com/maksim25y/http1/assets/131711956/5291450f-ad24-43bc-9722-c8fcfc849657)
</details>
<details><summary>Реализация</summary>
При работе над данным проектом мною был использованы следующий технологии: PostgreSQL, ApacheTomcat, JDBС, HttpServlets, Maven, JUNIT5.
  
База данных:
  
![image](https://github.com/maksim25y/http1/assets/131711956/e10d065f-6ccf-455c-92f8-0a5315de7f66)

</details>



















