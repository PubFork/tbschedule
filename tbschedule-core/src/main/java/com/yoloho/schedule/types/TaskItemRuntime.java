package com.yoloho.schedule.types;

import com.yoloho.schedule.util.ScheduleUtil;

/**
 * Task Item Runtime
 * 
 * @author xuannan
 *
 */
public class TaskItemRuntime {
    public enum TaskItemSts {
        ACTIVTE, FINISH, HALT
    }

    /**
     * 处理任务类型
     */
    private String runningEntry;
    private String taskName;
    private String ownSign;

    /**
     * 完成状态
     */
    private TaskItemSts sts = TaskItemSts.ACTIVTE;

    /**
     * 任务处理需要的参数
     */
    private String dealParameter = "";

    /**
     * 任务处理情况,用于任务处理器会写一些信息
     */
    private String dealDesc = "";

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
        this.runningEntry = ScheduleUtil.runningEntryFromTaskName(taskName, ownSign);
    }

    /**
     * 任务队列ID
     */
    private String taskItem;
    /**
     * 持有当前任务队列的任务处理器
     */
    private String currentScheduleServer;
    /**
     * 正在申请此任务队列的任务处理器
     */
    private String requestScheduleServer;

    public String getRunningEntry() {
        return runningEntry;
    }

    public String getTaskItem() {
        return taskItem;
    }

    public void setTaskItem(String aTaskItem) {
        this.taskItem = aTaskItem;
    }

    public String getCurrentScheduleServer() {
        return currentScheduleServer;
    }

    public void setCurrentScheduleServer(String currentScheduleServer) {
        this.currentScheduleServer = currentScheduleServer;
    }

    public String getRequestScheduleServer() {
        return requestScheduleServer;
    }

    public void setRequestScheduleServer(String requestScheduleServer) {
        this.requestScheduleServer = requestScheduleServer;
    }

    public String getOwnSign() {
        return ownSign;
    }

    public void setOwnSign(String ownSign) {
        this.ownSign = ownSign;
        this.runningEntry = ScheduleUtil.runningEntryFromTaskName(taskName, ownSign);
    }

    public String toString() {
        return new StringBuilder("RUNNING_ENTRY=").append(this.runningEntry)
                .append(":TASK_ITEM=").append(this.taskItem)
                .append(":CUR_SERVER=").append(this.currentScheduleServer)
                .append(":REQ_SERVER=").append(this.requestScheduleServer)
                .append(":DEAL_PARAMETER=").append(this.dealParameter)
                .toString();
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setSts(TaskItemSts sts) {
        this.sts = sts;
    }

    public TaskItemSts getSts() {
        return sts;
    }

    public void setDealParameter(String dealParameter) {
        this.dealParameter = dealParameter;
    }

    public String getDealParameter() {
        return dealParameter;
    }

}