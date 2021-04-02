package at.zachner.PaymentGraphQLPOC.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import at.zachner.PaymentGraphQLPOC.dao.entity.Payment;
import at.zachner.PaymentGraphQLPOC.service.PaymentService;

@Component
public class PaymentMutation implements GraphQLMutationResolver {
    @Autowired
    private PaymentService paymentService;

    public Payment createPayment(final int amount, final String receiver) {
        return this.paymentService.createPayment(amount, receiver);
    }
}