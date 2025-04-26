package com.LinguaNova.IdiomaGo.util.mapper.impl.word;

import com.LinguaNova.IdiomaGo.persistence.entity.WordEntity;
import com.LinguaNova.IdiomaGo.presentation.dto.word.WordDTO;
import com.LinguaNova.IdiomaGo.util.mapper.interfaces.word.IWordMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WordMapper implements IWordMapper {

	@Override
	public WordDTO mapTo(WordEntity wordEntity) {
		return INSTANCE.mapTo(wordEntity);
	}

	@Override
	public WordEntity mapFrom(WordDTO wordDTO) {
		return INSTANCE.mapFrom(wordDTO);
	}

	@Override
	public List<WordDTO> mapToList(List<WordEntity> wordEntities) {
		return INSTANCE.mapToList(wordEntities);
	}

	@Override
	public List<WordEntity> mapFromList(List<WordDTO> wordDTOS) {
		return INSTANCE.mapFromList(wordDTOS);
	}
}
