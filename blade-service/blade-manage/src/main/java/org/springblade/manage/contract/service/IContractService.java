/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.manage.contract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.manage.contract.entity.Contract;
import org.springblade.manage.contract.page.ContractPage;
import org.springblade.manage.contract.vo.ContractVO;

/**
 *  服务类
 */
public interface IContractService extends IService<Contract> {

	/**
	 * 自定义 分页
	 * @param contractPage
	 * @return
	 */
	ContractPage<ContractVO> selectAllPage(ContractPage contractPage);

}
