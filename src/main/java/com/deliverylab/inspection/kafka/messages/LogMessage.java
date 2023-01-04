
package com.deliverylab.inspection.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import com.deliverylab.inspection.models.Log;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage implements Serializable {
    private Log log;
    String action;
}
