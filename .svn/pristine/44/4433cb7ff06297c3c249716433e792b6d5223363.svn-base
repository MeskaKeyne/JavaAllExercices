package be.steformations.pc.service.contacts.soap.interfaces;

import be.steformations.pc.java_data.contacts.dto.TagDto;

@javax.jws.WebService
public interface TagSoapService {

	java.util.List<TagDto> findAllTags();
	TagDto findOneTagById(int id);
	TagDto findOneTagByValue(String value);
	TagDto createAndSaveTag(String value);
	TagDto removeTag(int id);
}
