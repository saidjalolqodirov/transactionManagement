package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.transaction.TransactionCreateDTO;
import uz.qodirov.transactionmanagement.dto.transaction.TransactionDTO;
import uz.qodirov.transactionmanagement.dto.transaction.TransactionUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Transaction;

/**
 * @author: Saidjalol Qodirov 2/5/2023 8:18 PM
 */
@Component
@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<TransactionDTO, Transaction, TransactionCreateDTO, TransactionUpdateDTO> {
}
