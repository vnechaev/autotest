package question.code;

public class MsgFromSourceToTarget extends Msg {

    public MsgFromSourceToTarget(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Abonent abonent) {
        if (abonent instanceof Source) {
            execute((Source) abonent);
        }
    }

    public void execute(Source source) {
        source.sendMessageTOTarget(this.getTo());
    }
}
