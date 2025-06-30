INSERT INTO language (name, code) VALUES
('spanish', 'es'),
('english', 'en'),
('portuguese', 'pt'),
('french', 'fr'),
('german', 'de');

INSERT INTO users (username, password, email, verified) VALUES
('ADMIN', '$2a$10$FT/jRbMf1Xvto20zNpnnxuVBpzTT7eUQnd8WifndX45svTg06c7Tu', 'edwin@admin.com', 1);

INSERT INTO word (name) VALUES
('sol'),
('agua'),
('libro'),
('perro'),
('casa');

INSERT INTO category (name) VALUES
('Nature'),
('Technology'),
('Education'),
('Animals'),
('Home');

-- Palabra: sol
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
(1, 1, 1, 1, 'sol', 'El sol brilla fuerte hoy.', 'Astro que da luz y calor a la Tierra.', 'PUBLIC'),
(1, 1, 2, 1, 'sun', 'The sun is shining brightly today.', 'Star that provides light and heat to Earth.', 'PUBLIC'),
(1, 1, 3, 1, 'sol', 'O sol está brilhando hoje.', 'Estrela que fornece luz e calor à Terra.', 'PUBLIC'),
(1, 1, 4, 1, 'soleil', 'Le soleil brille aujourd\'hui.', 'Astre fournissant lumière et chaleur à la Terre.', 'PUBLIC'),
(1, 1, 5, 1, 'Sonne', 'Die Sonne scheint heute.', 'Himmelskörper, der Licht und Wärme liefert.', 'PUBLIC');

-- Palabra: agua
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
(1, 2, 1, 1, 'agua', 'Bebo un vaso de agua.', 'Líquido transparente esencial para la vida.', 'PUBLIC'),
(1, 2, 2, 1, 'water', 'I drink a glass of water.', 'Transparent liquid essential for life.', 'PUBLIC'),
(1, 2, 3, 1, 'água', 'Eu bebo um copo de água.', 'Líquido transparente essencial à vida.', 'PUBLIC'),
(1, 2, 4, 1, 'eau', 'Je bois un verre d\'eau.', 'Liquide transparent essentiel à la vie.', 'PUBLIC'),
(1, 2, 5, 1, 'Wasser', 'Ich trinke ein Glas Wasser.', 'Transparente Flüssigkeit, lebenswichtig.', 'PUBLIC');

-- Palabra: libro
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
(1, 3, 1, 3, 'libro', 'Estoy leyendo un libro.', 'Conjunto de hojas impresas encuadernadas.', 'PUBLIC'),
(1, 3, 2, 3, 'book', 'I am reading a book.', 'Collection of printed pages bound together.', 'PUBLIC'),
(1, 3, 3, 3, 'livro', 'Estou lendo um livro.', 'Conjunto de folhas impressas encadernadas.', 'PUBLIC'),
(1, 3, 4, 3, 'livre', 'Je lis un livre.', 'Ensemble de feuilles imprimées reliées.', 'PUBLIC'),
(1, 3, 5, 3, 'Buch', 'Ich lese ein Buch.', 'Sammlung gedruckter Seiten, gebunden.', 'PUBLIC');

-- Palabra: perro
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility) VALUES
(1, 4, 1, 4, 'perro', 'Mi perro es muy juguetón.', 'Animal doméstico, fiel y amigable.', 'PUBLIC'),
(1, 4, 2, 4, 'dog', 'My dog is very playful.', 'Domestic animal, loyal and friendly.', 'PUBLIC'),
(1, 4, 3, 4, 'cão', 'Meu cão é muito brincalhão.', 'Animal doméstico, leal e amigável.', 'PUBLIC'),
(1, 4, 4, 4, 'chien', 'Mon chien est très joueur.', 'Animal domestique, fidèle et amical.', 'PUBLIC'),
(1, 4, 5, 4, 'Hund', 'Mein Hund ist sehr verspielt.', 'Haustier, treu und freundlich.', 'PUBLIC');

-- Palabra: casa
INSERT INTO word_translation (user_id, word_id, language_id, category_id, translated_word, translated_example, translated_description, visibility)VALUES
(1, 5, 1, 5, 'casa', 'Mi casa tiene un jardín.', 'Edificio donde vive una persona o familia.', 'PUBLIC'),
(1, 5, 2, 5, 'house', 'My house has a garden.', 'Building where a person or family lives.', 'PUBLIC'),
(1, 5, 3, 5, 'casa', 'Minha casa tem um jardim.', 'Edifício onde vive uma pessoa ou família.', 'PUBLIC'),
(1, 5, 4, 5, 'maison', 'Ma maison a un jardin.', 'Bâtiment où vit une personne ou une famille.', 'PUBLIC'),
(1, 5, 5, 5, 'Haus', 'Mein Haus hat einen Garten.', 'Gebäude, in dem eine Person oder Familie lebt.', 'PUBLIC');

