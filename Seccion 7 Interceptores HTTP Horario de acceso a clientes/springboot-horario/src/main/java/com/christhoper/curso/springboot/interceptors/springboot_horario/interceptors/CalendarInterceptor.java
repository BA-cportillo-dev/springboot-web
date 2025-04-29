package com.christhoper.curso.springboot.interceptors.springboot_horario.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;   
    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler) throws Exception {
        
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("La hora es: " + hour);

        if (hour >= open && hour < close) {
            StringBuilder message = new StringBuilder("Bienvenidos al sistema de atencion a clientes!");
            message.append(" Horario de atencion es desde las ");
            message.append(open);
            message.append(" hrs.");
            message.append(" hasta las ");
            message.append(close);
            message.append(" hrs.");
            message.append(" Gracias por su visita!");
            if (request != null) {
                request.setAttribute("message", message.toString());
            }
            return true;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        StringBuilder message = new StringBuilder("Cerrado, fuera del horario de atencion");
        message.append(" por favor visitenos desde las ");
        message.append(open);
        message.append(" hrs.");
        message.append(" hasta las ");
        message.append(close);
        message.append(" hrs.");
        message.append(" Gracias por su visita!");
        data.put("message", message.toString());
        data.put("date", new Date().toString());

        if (response != null) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            response.getWriter().write(mapper.writeValueAsString(data));
        }
        return false;
    }

    @Override
    public void postHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle");
        
    }
}
