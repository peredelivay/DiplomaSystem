-- roles
INSERT INTO roles (id, name) VALUES
  (1, 'STUDENT'),
  (2, 'SUPERVISOR'),
  (3, 'ADMIN');

-- users (mock passwords in plain text for testing only)
INSERT INTO users (id, name, email, password, group_name, role_id, supervisor_id) VALUES
  (1, 'Иван Студент', 'ivan.student@example.com', 'password1', 'ИКБО-32-21', 1, 2),
  (2, 'Пётр Руководитель', 'petr.supervisor@example.com', 'password2', NULL,       2, NULL),
  (3, 'Админ',             'admin@example.com',         'password3', NULL,         3, NULL);

-- practices
INSERT INTO practices (id, student_id, practice_name, versions_amount, last_modified) VALUES
  (1, 1, 'ВКР: Автоматизация процесса', 1, NOW());

-- versions
INSERT INTO versions (id, practice_id, version_number, upload_time) VALUES
  (1, 1, 1, NOW());

-- blocks
INSERT INTO blocks (id, version_id, order_number, content_type, content) VALUES
  (1, 1, 1, 'TITLE', 'Заголовок первой версии'),
  (2, 1, 2, 'TEXT',  'Текст первого раздела отчёта.'),
  (3, 1, 3, 'IMAGE', '/uploads/1/1/image1.png'),
  (4, 1, 4, 'LIST',  '["Шаг 1","Шаг 2","Шаг 3"]'),
  (5, 1, 5, 'TABLE', '{"headers":["Колонка A","Колонка B"],"rows":[[100,200],[300,400]]}');

-- chats
INSERT INTO chats (id, student_id, supervisor_id) VALUES
  (1, 1, 2);

-- messages
INSERT INTO messages (id, chat_id, sender_id, message_text, sent_time) VALUES
  (1, 1, 1, 'Здравствуйте, отправил черновик.', NOW()),
  (2, 1, 2, 'Принял, скоро проверю.',  NOW());

-- notifications
INSERT INTO notifications (id, user_id, type, message, status, created_at) VALUES
  (1, 1, 'INFO',     'Практика создана, приступайте к заполнению.', false, NOW()),
  (2, 2, 'REMINDER', 'У студента новая версия практики на проверку.', false, NOW());
