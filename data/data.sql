-- Роли
INSERT INTO roles (role_id, name) VALUES (1, 'Student');
INSERT INTO roles (role_id, name) VALUES (2, 'Supervisor');
INSERT INTO roles (role_id, name) VALUES (3, 'Admin');

-- Пользователи: студент, научный руководитель и администратор.
INSERT INTO users (user_id, name, email, password, role_id)
VALUES (2, 'Supervisor One', 'supervisor1@example.com', 'password', 2);

INSERT INTO users (user_id, name, email, password, role_id)
VALUES (3, 'Admin One', 'admin@example.com', 'password', 3);

INSERT INTO users (user_id, name, email, password, role_id, supervisor_id)
VALUES (1, 'Student One', 'student1@example.com', 'password', 1, 2);

-- Практика (отчет).
INSERT INTO practice_reports (report_id, student_id, supervisor_id, status, created_at)
VALUES (1, 1, 2, 'DRAFT', now());

-- Версия практики
INSERT INTO practice_versions (version_number, created_at, practice_report_id, version_id, status)
VALUES (1, now(), 1, 1, 'DRAFT');

-- Блоки (пример текстового блока)
INSERT INTO blocks (position, block_id, version_id, content, type)
VALUES (1, 1, 1, 'This is sample text content for the practice report.', 'TEXT');

-- Чат: создание беседы для студента с его руководителем
INSERT INTO conversations (conv_id, student_id, supervisor_id)
VALUES (1, 1, 2);

-- Сообщения в чате
INSERT INTO messages (msg_id, conv_id, sender_id, message_text, sent_at)
VALUES (1, 1, 1, 'Hello, I need help with my report.', now());

INSERT INTO messages (msg_id, conv_id, sender_id, message_text, sent_at)
VALUES (2, 1, 2, 'Sure, please send your draft for review.', now());

-- Уведомление для студента
INSERT INTO notifications (notification_id, user_id, type, message, is_read, created_at)
VALUES (1, 1, 'INFO', 'Your practice report has been saved as draft.', false, now());
