package com.boot.controller;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

/**
 * Created by zy on 2016/5/23.
 */
@Controller
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping()
    public String list(Model model) {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        model.addAttribute("sessions", sessions);
        model.addAttribute("sesessionCount", sessions.size());
        return "sessionlist";
    }

    @RequestMapping("/forceLogout/{sessionId}")
    public String forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
        try {
            Session session = sessionDAO.readSession(sessionId);

            if (session != null) {
                session.setAttribute("session.force.logout", Boolean.TRUE);
            }
        } catch (Exception e) {/*ignore*/}
        redirectAttributes.addFlashAttribute("msg", "强制退出成功！");
        return "redirect:/sessions";
    }
}
