package uz.qodirov.transactionmanagement.controller;

import uz.qodirov.transactionmanagement.services.BaseService;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:26 PM
 */
public abstract class AbstractController<S extends BaseService> {
    public final S service;

    public AbstractController(S service) {
        this.service = service;
    }
}
