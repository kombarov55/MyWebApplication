package com.vk.kombarov_nikolay.model.user.util;

import com.vk.kombarov_nikolay.model.user.UserServiceImpl;
import org.apache.log4j.Logger;

/**
 * Created by nikolaykombarov on 24.01.17.
 */
public class UserManagerLogger {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserManagerLogger() {
    }

    public UserManagerLogger(Logger logger) {
        this.logger = logger;
    }

    public void logInitialization() {
        logger.info("Singletons were initialized");
    }

    public void logCratingDialog(String username1, String username2) {
        logger.info(String.format("Request about creating dialog of #%s and #%s was sent to dao",
                username1, username2));
    }

    public void logCreatingUser(String username) {
        logger.info(String.format("User #%s was added to database", username));
    }

    public void logLoadingUsersStarted() {
        logger.info("Loading users has started");
    }

    public void logLoadingUsersSucceeded() {
        logger.info("Loading users has suceeded");
    }

    public void logAddingDialogsStarted() {
        logger.info("Adding dialogs to users has started");
    }

    public void logAddingDialogsSucceeded() {
        logger.info("Adding dialogs to users has ended");
    }
}

