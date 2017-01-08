package pl.wat.pz.application.logic.enumeric;

/**
 * Created by Kamil on 2017-01-06.
 */
public enum LoanStatusEnum{
    REJECTED(1l),OFFER(2L),ACCEPTED(3l),IN_PROGRESS(4l),CANCELED(5L),COMPLETED(6L);

    private long id;

    LoanStatusEnum(long id){
        this.id=id;
    }

    public long getId() {
        return id;
    }
}