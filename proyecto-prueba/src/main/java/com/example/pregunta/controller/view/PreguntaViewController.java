package com.example.pregunta.controller.view;

import com.example.pregunta.entity.Pregunta;
import com.example.pregunta.service.PreguntaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/view/preguntas")
public class PreguntaViewController {
	

    private final PreguntaService preguntaService;

    public PreguntaViewController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping
    public String listPreguntas(Model model, @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        Page<Pregunta> paginaPreguntas = preguntaService.findAll(pageable);
        model.addAttribute("paginaPreguntas", paginaPreguntas);
        return "preguntas/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("pregunta", new Pregunta());
        return "preguntas/form";
    }

    @PostMapping
    public String createPregunta(@Valid Pregunta pregunta, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "preguntas/form";
        }
        preguntaService.save(pregunta);
        redirectAttributes.addFlashAttribute("successMessage", "¡Pregunta creada con éxito!");
        return "redirect:/view/preguntas";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pregunta pregunta = preguntaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pregunta Id:" + id));
        model.addAttribute("pregunta", pregunta);
        return "preguntas/form";
    }

    @GetMapping("/view/{id}")
    public String showViewPage(@PathVariable("id") long id, Model model) {
        Pregunta pregunta = preguntaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pregunta Id:" + id));
        model.addAttribute("pregunta", pregunta);
        return "preguntas/view";
    }

    @PostMapping("/update/{id}")
    public String updatePregunta(@PathVariable("id") long id, @Valid Pregunta pregunta,
                                 BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            pregunta.setId(id);
            return "preguntas/form";
        }
        preguntaService.save(pregunta);
        redirectAttributes.addFlashAttribute("successMessage", "¡Pregunta actualizada con éxito!");
        return "redirect:/view/preguntas";
    }

    @GetMapping("/delete/{id}")
    public String deletePregunta(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        preguntaService.findById(id).ifPresent(pregunta -> preguntaService.deleteById(id));
        redirectAttributes.addFlashAttribute("successMessage", "¡Pregunta eliminada con éxito!");
        return "redirect:/view/preguntas";
    }
}
