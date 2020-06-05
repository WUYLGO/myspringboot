//package com.wyl.research.designpattern.modelPattern;
//
//import com.cqfae.pmo.zhcz.bgt.base.workflow.FlowDto;
//import com.cqfae.pmo.zhcz.bgt.base.workflow.FlowItemDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.transaction.TransactionSystemException;
//
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//@Slf4j
//public class BatchActionInvoker {
//
//    public BatchResultDto doBatchAction(FlowDto flowDto, FlowItemHandler handler){
//        FlowItemDto[] items = flowDto.getFlowItem();
//        int size = items.length;
//        return doBatchAction(size, new ServiceBatchExecutor() {
//            @Override
//            public void execute(int i) {
//                handler.handle(items[i]);
//            }
//
//            public void handleException(int i, Exception ex, BatchResultDto batchResultDto){
//                handler.handleException(items[i], ex, batchResultDto);
//            }
//        });
//    }
//
//    /**
//     *
//     * @param be 构建参数
//     * @return
//     */
//    public BatchResultDto doBatchAction(int size, ServiceBatchExecutor be){
//        BatchResultDto resultDto = new BatchResultDto(size);
//
//        for(int i = 0; i < size; i++){
//            try {
//                be.execute(i);
//                resultDto.addSuccess();
//            }catch(Exception ex){
//                log.error(ex.getMessage(), ex);
//
//                if (ex instanceof TransactionSystemException) {
//
//                    Throwable throwable = ((TransactionSystemException) ex).getRootCause();
//                    if (throwable != null) {
//
//
//
//                        be.handleException(i, (Exception) throwable, resultDto);
//                    } else {
//                        be.handleException(i, ex, resultDto);
//                    }
//                } else {
//                    be.handleException(i, ex, resultDto);
//                }
//
//            }
//        }
//        return resultDto;
//    }
//
//    /**
//     *
//     * @param serviceMethodInvoker 执行方法
//     * @param size 数组长度
//     * @param paramFunction 构建参数
//     * @return
//     */
//    public BatchResultDto doBatchAction(Consumer<Object[]> serviceMethodInvoker, int size, Function<Integer, Object[]> paramFunction){
//        BatchResultDto resultDto = new BatchResultDto(size);
//
//        for(int i = 0; i < size; i++){
//            try {
//                Object[] itemParam = paramFunction.apply(i);
//                serviceMethodInvoker.accept(itemParam);
//                resultDto.addSuccess();
//            }catch(Exception ex){
//                log.error(ex.getMessage(), ex);
//                resultDto.addError(  ex.getMessage());
//            }
//        }
//        return resultDto;
//    }
//
//}
