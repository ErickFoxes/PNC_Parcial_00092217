package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;


@Controller
public class MainController {

	@Autowired
    private CategoriaDAO categoriaDAO;
	
	@Autowired
    private LibroDAO libroDAO;
	
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/verCategoria")
	public ModelAndView verCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria",categoria);
		mav.setViewName("ingresarCategoria");
		return mav;
	}
	
	@RequestMapping("/verLibro")
	public ModelAndView verLibro() {
		Libro libro = new Libro();
		List<Categoria> categoriaSelect = categoriaDAO.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("libro",libro);
		mav.addObject("categoriaSelect",categoriaSelect);
		mav.setViewName("ingresarLibro");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresar(@Valid @ModelAttribute Categoria categoria, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresarCategoria");
		}
		else {
			categoriaDAO.save(categoria);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresar(@Valid @ModelAttribute Libro libro, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresarLibro");
		}
		else {
			libroDAO.save(libro);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
}
