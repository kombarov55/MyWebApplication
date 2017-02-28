package com.vk.kombarov_nikolay.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by nikolaykombarov on 01.01.17.
 */

public class Initializer implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        ServletContext ctx = servletContextEvent.getServletContext();
//        String connectionStatus = "OK";
//        try {
//
//            InitialContext ic = new InitialContext();
//            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/myDBTest");
//
//            Dao userDao = new UserDao(ds);
//            Dao dialogDao = new DialogDao(ds);
//            IMessageDao messageDao = new MessageDao(ds);
//
//            userDao = new GenericTracer<>(userDao).getTracer();
//            dialogDao = new GenericTracer<>(dialogDao).getTracer();
//            messageDao = new GenericTracer<>(messageDao).getTracer();
//
//            MessengerService messengerService = new MessengerService(dialogDao, messageDao);
//            messengerService = new GenericTracer<>(messengerService).getTracer();
//
//            UserService userManager = new UserServiceImpl(messengerService.getDialogList(), userDao);
//            userManager = new GenericTracer<>(userManager).getTracer();
//
//            AdderToSession.setUserManager(userManager);
//
//            ctx.setAttribute("userDao", userDao);
//            ctx.setAttribute("dialogDao", dialogDao);
//            ctx.setAttribute("messageDao", messageDao);
//
//            ctx.setAttribute("UserServiceImpl", userManager);
//            ctx.setAttribute("MessengerService", messengerService);
//
//        } catch (Exception e) {
//            connectionStatus = "FAILED";
//        } finally {
//            ctx.setAttribute("connection_status", connectionStatus);
//        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}
