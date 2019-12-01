package org.launchcode.controllers;


import ognl.Evaluation;
import org.launchcode.models.Post;
import org.launchcode.models.Reply;
import org.launchcode.models.data.ReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private ReplyDao replyDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("replies", replyDao.findAll());
        return "post/index";
    }

    @RequestMapping(value = "reply/{replyId}", method = RequestMethod.GET)
    public String replyForm(Model model, @PathVariable int replyId) {

        model.addAttribute("title", "reply");
        model.addAttribute("reply", replyDao.findOne(replyId));

        return "post/reply";

    }

    @RequestMapping(value = "reply/{replyId}", method = RequestMethod.POST)
    public String processReplyForm(@PathVariable int replyId, @ModelAttribute Reply newReply) {
        Post editedReply = replyDao.findOne(replyId);
        editedReply.setReply(newReply.getReply());
        replyDao.save(editedReply);

        return "redirect:/post";


    }


}
}
