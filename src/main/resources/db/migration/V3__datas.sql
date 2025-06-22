INSERT INTO language (name, code) VALUES
('spanish', 'es'),
('english', 'en'),
('portuguese', 'pt'),
('french', 'fr'),
('german', 'de');

INSERT INTO users (username, password, email) VALUES
('edwin', '$2a$10$FT/jRbMf1Xvto20zNpnnxuVBpzTT7eUQnd8WifndX45svTg06c7Tu', 'edwin@example.com'),
('sara', '$2a$10$FT/jRbMf1Xvto20zNpnnxuVBpzTT7eUQnd8WifndX45svTg06c7Tu', 'sara@example.com'),
('marco.pt', '$2a$10$FT/jRbMf1Xvto20zNpnnxuVBpzTT7eUQnd8WifndX45svTg06c7Tu', 'marco@example.com');

INSERT INTO word (name) VALUES
('sol'),
('agua'),
('libro'),
('perro'),
('casa');

-- Palabra: sol
INSERT INTO word_translation (word_id, language_id, translated_word, translated_example, translated_description) VALUES
(1, 1, 'sol', 'El sol brilla fuerte hoy.', 'Astro que da luz y calor a la Tierra.'),
(1, 2, 'sun', 'The sun is shining brightly today.', 'Star that provides light and heat to Earth.'),
(1, 3, 'sol', 'O sol está brilhando hoje.', 'Estrela que fornece luz e calor à Terra.'),
(1, 4, 'soleil', 'Le soleil brille aujourd\'hui.', 'Astre fournissant lumière et chaleur à la Terre.'),
(1, 5, 'Sonne', 'Die Sonne scheint heute.', 'Himmelskörper, der Licht und Wärme liefert.');

-- Palabra: agua
INSERT INTO word_translation (word_id, language_id, translated_word, translated_example, translated_description) VALUES
(2, 1, 'agua', 'Bebo un vaso de agua.', 'Líquido transparente esencial para la vida.'),
(2, 2, 'water', 'I drink a glass of water.', 'Transparent liquid essential for life.'),
(2, 3, 'água', 'Eu bebo um copo de água.', 'Líquido transparente essencial à vida.'),
(2, 4, 'eau', 'Je bois un verre d\'eau.', 'Liquide transparent essentiel à la vie.'),
(2, 5, 'Wasser', 'Ich trinke ein Glas Wasser.', 'Transparente Flüssigkeit, lebenswichtig.');

-- Palabra: libro
INSERT INTO word_translation (word_id, language_id, translated_word, translated_example, translated_description) VALUES
(3, 1, 'libro', 'Estoy leyendo un libro.', 'Conjunto de hojas impresas encuadernadas.'),
(3, 2, 'book', 'I am reading a book.', 'Collection of printed pages bound together.'),
(3, 3, 'livro', 'Estou lendo um livro.', 'Conjunto de folhas impressas encadernadas.'),
(3, 4, 'livre', 'Je lis un livre.', 'Ensemble de feuilles imprimées reliées.'),
(3, 5, 'Buch', 'Ich lese ein Buch.', 'Sammlung gedruckter Seiten, gebunden.');

-- Palabra: perro
INSERT INTO word_translation (word_id, language_id, translated_word, translated_example, translated_description) VALUES
(4, 1, 'perro', 'Mi perro es muy juguetón.', 'Animal doméstico, fiel y amigable.'),
(4, 2, 'dog', 'My dog is very playful.', 'Domestic animal, loyal and friendly.'),
(4, 3, 'cão', 'Meu cão é muito brincalhão.', 'Animal doméstico, leal e amigável.'),
(4, 4, 'chien', 'Mon chien est très joueur.', 'Animal domestique, fidèle et amical.'),
(4, 5, 'Hund', 'Mein Hund ist sehr verspielt.', 'Haustier, treu und freundlich.');

-- Palabra: casa
INSERT INTO word_translation (word_id, language_id, translated_word, translated_example, translated_description) VALUES
(5, 1, 'casa', 'Mi casa tiene un jardín.', 'Edificio donde vive una persona o familia.'),
(5, 2, 'house', 'My house has a garden.', 'Building where a person or family lives.'),
(5, 3, 'casa', 'Minha casa tem um jardim.', 'Edifício onde vive uma pessoa ou família.'),
(5, 4, 'maison', 'Ma maison a un jardin.', 'Bâtiment où vit une personne ou une famille.'),
(5, 5, 'Haus', 'Mein Haus hat einen Garten.', 'Gebäude, in dem eine Person oder Familie lebt.');

