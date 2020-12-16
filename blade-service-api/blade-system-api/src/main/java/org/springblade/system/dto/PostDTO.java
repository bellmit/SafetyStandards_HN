/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.system.entity.Post;

/**
 * 数据传输对象实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostDTO extends Post {
	private static final long serialVersionUID = 1L;

}
