-- Idiomas
INSERT INTO language (name, code) VALUES
('spanish', 'es'),
('english', 'en'),
('portuguese', 'pt'),
('french', 'fr'),
('german', 'de');

-- Usuario administrador
INSERT INTO users (username, password, email, verified) VALUES
('ADMIN', '$2a$10$FT/jRbMf1Xvto20zNpnnxuVBpzTT7eUQnd8WifndX45svTg06c7Tu', 'edwin@admin.com', TRUE);

-- Palabras
INSERT INTO word (name) VALUES
('sol'),
('agua'),
('libro'),
('perro'),
('casa');

-- Categorías
INSERT INTO category (name) VALUES
('Nature'),
('Technology'),
('Education'),
('Animals'),
('Home');

-- Traducciones de la palabra: sol
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'sol'), (SELECT id FROM language WHERE code = 'es'), (SELECT id FROM category WHERE name = 'Nature'), 'sol', 'El sol brilla fuerte hoy.', 'Astro que da luz y calor a la Tierra.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'sol'), (SELECT id FROM language WHERE code = 'en'), (SELECT id FROM category WHERE name = 'Nature'), 'sun', 'The sun is shining brightly today.', 'Star that provides light and heat to Earth.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'sol'), (SELECT id FROM language WHERE code = 'pt'), (SELECT id FROM category WHERE name = 'Nature'), 'sol', 'O sol está brilhando hoje.', 'Estrela que fornece luz e calor à Terra.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'sol'), (SELECT id FROM language WHERE code = 'fr'), (SELECT id FROM category WHERE name = 'Nature'), 'soleil', 'Le soleil brille aujourd''hui.', 'Astre fournissant lumière et chaleur à la Terre.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'sol'), (SELECT id FROM language WHERE code = 'de'), (SELECT id FROM category WHERE name = 'Nature'), 'Sonne', 'Die Sonne scheint heute.', 'Himmelskörper, der Licht und Wärme liefert.', 'PUBLIC');

-- Traducciones de la palabra: agua
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'agua'), (SELECT id FROM language WHERE code = 'es'), (SELECT id FROM category WHERE name = 'Nature'), 'agua', 'Bebo un vaso de agua.', 'Líquido transparente esencial para la vida.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'agua'), (SELECT id FROM language WHERE code = 'en'), (SELECT id FROM category WHERE name = 'Nature'), 'water', 'I drink a glass of water.', 'Transparent liquid essential for life.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'agua'), (SELECT id FROM language WHERE code = 'pt'), (SELECT id FROM category WHERE name = 'Nature'), 'água', 'Eu bebo um copo de água.', 'Líquido transparente essencial à vida.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'agua'), (SELECT id FROM language WHERE code = 'fr'), (SELECT id FROM category WHERE name = 'Nature'), 'eau', 'Je bois un verre d''eau.', 'Liquide transparent essentiel à la vie.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'agua'), (SELECT id FROM language WHERE code = 'de'), (SELECT id FROM category WHERE name = 'Nature'), 'Wasser', 'Ich trinke ein Glas Wasser.', 'Transparente Flüssigkeit, lebenswichtig.', 'PUBLIC');

-- Traducciones de la palabra: libro
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'libro'), (SELECT id FROM language WHERE code = 'es'), (SELECT id FROM category WHERE name = 'Education'), 'libro', 'Estoy leyendo un libro.', 'Conjunto de hojas impresas encuadernadas.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'libro'), (SELECT id FROM language WHERE code = 'en'), (SELECT id FROM category WHERE name = 'Education'), 'book', 'I am reading a book.', 'Collection of printed pages bound together.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'libro'), (SELECT id FROM language WHERE code = 'pt'), (SELECT id FROM category WHERE name = 'Education'), 'livro', 'Estou lendo um livro.', 'Conjunto de folhas impressas encadernadas.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'libro'), (SELECT id FROM language WHERE code = 'fr'), (SELECT id FROM category WHERE name = 'Education'), 'livre', 'Je lis un livre.', 'Ensemble de feuilles imprimées reliées.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'libro'), (SELECT id FROM language WHERE code = 'de'), (SELECT id FROM category WHERE name = 'Education'), 'Buch', 'Ich lese ein Buch.', 'Sammlung gedruckter Seiten, gebunden.', 'PUBLIC');

-- Traducciones de la palabra: perro
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'perro'), (SELECT id FROM language WHERE code = 'es'), (SELECT id FROM category WHERE name = 'Animals'), 'perro', 'Mi perro es muy juguetón.', 'Animal doméstico, fiel y amigable.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'perro'), (SELECT id FROM language WHERE code = 'en'), (SELECT id FROM category WHERE name = 'Animals'), 'dog', 'My dog is very playful.', 'Domestic animal, loyal and friendly.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'perro'), (SELECT id FROM language WHERE code = 'pt'), (SELECT id FROM category WHERE name = 'Animals'), 'cão', 'Meu cão é muito brincalhão.', 'Animal doméstico, leal e amigável.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'perro'), (SELECT id FROM language WHERE code = 'fr'), (SELECT id FROM category WHERE name = 'Animals'), 'chien', 'Mon chien est très joueur.', 'Animal domestique, fidèle et amical.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'perro'), (SELECT id FROM language WHERE code = 'de'), (SELECT id FROM category WHERE name = 'Animals'), 'Hund', 'Mein Hund ist sehr verspielt.', 'Haustier, treu und freundlich.', 'PUBLIC');

-- Traducciones de la palabra: casa
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'casa'), (SELECT id FROM language WHERE code = 'es'), (SELECT id FROM category WHERE name = 'Home'), 'casa', 'Mi casa tiene un jardín.', 'Edificio donde vive una persona o familia.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'casa'), (SELECT id FROM language WHERE code = 'en'), (SELECT id FROM category WHERE name = 'Home'), 'house', 'My house has a garden.', 'Building where a person or family lives.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'casa'), (SELECT id FROM language WHERE code = 'pt'), (SELECT id FROM category WHERE name = 'Home'), 'casa', 'Minha casa tem um jardim.', 'Edifício onde vive uma pessoa ou família.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'casa'), (SELECT id FROM language WHERE code = 'fr'), (SELECT id FROM category WHERE name = 'Home'), 'maison', 'Ma maison a un jardin.', 'Bâtiment où vit une personne ou une famille.', 'PUBLIC'),
((SELECT id FROM users WHERE username = 'ADMIN'), (SELECT id FROM word WHERE name = 'casa'), (SELECT id FROM language WHERE code = 'de'), (SELECT id FROM category WHERE name = 'Home'), 'Haus', 'Mein Haus hat einen Garten.', 'Gebäude, in dem eine Person oder Familie lebt.', 'PUBLIC');
