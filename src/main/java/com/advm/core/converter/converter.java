package com.advm.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.advm.core.entity.Nota;
import com.advm.core.model.NotaModel;

@Component("converternota")
public class converter {
	
	public List<NotaModel> ListConverter(List<Nota> notas) {
		
		List<NotaModel> nm= new ArrayList<>();
		for(Nota nota: notas){
			nm.add(new NotaModel(nota));
		}
		
		return nm;
	}

}
