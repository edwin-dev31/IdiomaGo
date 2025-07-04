CREATE OR REPLACE VIEW view_word_footer_data AS
SELECT
    wt.id AS word_translation_id,
    u.username,
    u.image_url,
    wt.translated_word,
    l.name AS language_name,
    wt.created_at,

    COUNT(r.*) FILTER (WHERE r.emoji = '👍') AS reaction_like,
    COUNT(r.*) FILTER (WHERE r.emoji = '👎') AS reaction_dislike,
    COUNT(r.*) FILTER (WHERE r.emoji = '❤️') AS reaction_love,
    COUNT(r.*) FILTER (WHERE r.emoji = '🔥') AS reaction_fire,
    COUNT(r.*) FILTER (WHERE r.emoji = '💯') AS reaction_perfect

FROM word_translation wt
JOIN users u ON u.id = wt.user_id
JOIN language l ON l.id = wt.language_id
LEFT JOIN reaction r ON r.word_translation_id = wt.id

GROUP BY wt.id, u.username, u.image_url, wt.translated_word, l.name, wt.created_at;
