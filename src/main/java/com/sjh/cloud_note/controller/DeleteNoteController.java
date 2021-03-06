package com.sjh.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjh.cloud_note.service.NoteService;
import com.sjh.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId){
		NoteResult<Object> result = noteService.DeleteNote(noteId);
		return result;
	}
}
